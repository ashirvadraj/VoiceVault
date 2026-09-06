function Get-VerifiedVideos($query, $max) {
    $q = [System.Uri]::EscapeDataString($query)
    $raw = curl.exe -s -m 8 "https://www.youtube.com/results?search_query=$q"
    $regex = [regex]'\"videoId\":\"([a-zA-Z0-9_-]{11})\"'
    $mList = $regex.Matches($raw)
    $ids = $mList | ForEach-Object { $_.Groups[1].Value } | Select-Object -Unique
    $verified = @()
    foreach ($id in $ids) {
        if ($verified.Count -ge $max) { break }
        $o = curl.exe -s -m 4 "https://www.youtube.com/oembed?url=https://www.youtube.com/watch?v=$id&format=json"
        if ($o -and $o.StartsWith("{")) {
            try {
                $j = $o | ConvertFrom-Json
                if ($j.title) {
                    $verified += [PSCustomObject]@{ id = $id; title = $j.title; author = $j.author_name }
                }
            } catch {}
        }
    }
    return $verified
}

$all = @{}

$all["Vajpayee"] = Get-VerifiedVideos "Atal Bihari Vajpayee speech" 8
$all["Kalam"] = Get-VerifiedVideos "APJ Abdul Kalam inspirational speech" 8
$all["Nehru"] = Get-VerifiedVideos "Jawaharlal Nehru Tryst with Destiny speech" 6
$all["Sachin"] = Get-VerifiedVideos "Sachin Tendulkar farewell speech Wankhede" 5
$all["Shastri"] = Get-VerifiedVideos "Lal Bahadur Shastri speech" 5
$all["Radhakrishnan"] = Get-VerifiedVideos "Sarvepalli Radhakrishnan speech" 5
$all["Bose"] = Get-VerifiedVideos "Netaji Subhash Chandra Bose speech" 5
$all["Patel"] = Get-VerifiedVideos "Sardar Patel speech" 5
$all["MLK"] = Get-VerifiedVideos "Martin Luther King speech" 5
$all["Churchill"] = Get-VerifiedVideos "Winston Churchill speech" 5
$all["JFK"] = Get-VerifiedVideos "John F Kennedy speech" 5
$all["Mandela"] = Get-VerifiedVideos "Nelson Mandela speech" 5
$all["Hitler"] = Get-VerifiedVideos "Adolf Hitler speech English subtitles" 4
$all["Obama"] = Get-VerifiedVideos "Barack Obama speech" 4
$all["Vivekananda"] = Get-VerifiedVideos "Swami Vivekananda Chicago speech 1893" 4

$all | ConvertTo-Json -Depth 4 | Out-File "verified_speeches.json" -Encoding utf8
Write-Output "ALL SCRAPING COMPLETED"
