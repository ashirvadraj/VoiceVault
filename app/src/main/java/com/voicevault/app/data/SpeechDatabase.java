package com.voicevault.app.data;

import android.graphics.Color;
import com.voicevault.app.model.Speaker;
import com.voicevault.app.model.Speech;
import java.util.ArrayList;
import java.util.List;

public class SpeechDatabase {

    private static List<Speaker> speakers;

    public static List<Speaker> getAllSpeakers() {
        if (speakers != null) return speakers;
        speakers = new ArrayList<>();

        // =========================================================================
        // 1. ATAL BIHARI VAJPAYEE (Official & Full Archival Speeches)
        // =========================================================================
        Speaker vajpayee = new Speaker("Atal Bihari Vajpayee", "🇮🇳 India", "AV", Color.parseColor("#E65100"));
        vajpayee.addSpeech(new Speech("Best Speeches of Atal Bihari Vajpayee (Sansad TV)", "Various", "ogow0QHQ3R4", "Atal Bihari Vajpayee", "Sansad TV official documentary & landmark parliamentary addresses (28 mins)"));
        vajpayee.addSpeech(new Speech("1996 Historic Speech: 13 Din Ki Sarkar (Parliament Live)", "1996", "zFoiNU_p3bQ", "Atal Bihari Vajpayee", "Full 25-minute resignation speech: 'Sarkarein aayengi, jayengi, desh rehna chahiye'"));
        vajpayee.addSpeech(new Speech("Samagrah Atal Ji: Stand Against Corruption", "1998", "WoiUaYRtins", "Atal Bihari Vajpayee", "Complete 74-minute address on probity in public life and clean governance"));
        vajpayee.addSpeech(new Speech("1977 Victory Rally Speech (Prasar Bharati Archives)", "1977", "nsJ_dRRvsBI", "Atal Bihari Vajpayee", "Historic 16-minute victory rally after the lifting of Emergency"));
        vajpayee.addSpeech(new Speech("Atal Yatra: Life and Visionary Contributions (Sansad TV)", "Various", "9FsclLVUrso", "Atal Bihari Vajpayee", "Official Sansad TV special chronicling his iconic parliamentary career (16 mins)"));
        vajpayee.addSpeech(new Speech("2000 Prime Minister Address on Good Health & Society", "2000", "lDgpGaoPEmw", "Atal Bihari Vajpayee", "Archival recording from Prasar Bharati of his address to national medical leaders (16 mins)"));
        vajpayee.addSpeech(new Speech("1971 Parliamentary Speech on Indo-Pak War", "1971", "p6vyF9u542c", "Atal Bihari Vajpayee", "Historic address in Parliament backing the armed forces during the 1971 liberation war"));
        vajpayee.addSpeech(new Speech("Parliament Speeches Marathon Collection", "Various", "TIhdMyj37eo", "Atal Bihari Vajpayee", "Comprehensive live parliament speeches of Atal Bihari Vajpayee (150 mins)"));
        speakers.add(vajpayee);

        // =========================================================================
        // 2. DR. APJ ABDUL KALAM (Official Full Addresses & Lectures)
        // =========================================================================
        Speaker kalam = new Speaker("Dr. APJ Abdul Kalam", "🇮🇳 India", "AK", Color.parseColor("#2E7D32"));
        kalam.addSpeech(new Speech("European Parliament Historic Address (Official EU)", "2007", "d36YFbYwlU8", "Dr. APJ Abdul Kalam", "Complete 47-minute speech to European Parliament on global energy & world peace"));
        kalam.addSpeech(new Speech("India Interacts with Dr. APJ Abdul Kalam (Sansad TV)", "2006", "9CKCfiX3uO0", "Dr. APJ Abdul Kalam", "Official Sansad TV 48-minute interactive session with youth, teachers, and innovators"));
        kalam.addSpeech(new Speech("Culture of Excellence (English Speeches)", "2005", "LEtP7HgGTu0", "Dr. APJ Abdul Kalam", "Full 23-minute oration with English subtitles on institutional leadership and ethics"));
        kalam.addSpeech(new Speech("Inspiring Address to the Youth & Nation", "Various", "i5WYp4wMXfc", "Dr. APJ Abdul Kalam", "19-minute keynote address with full subtitles on courage, dreams, and action"));
        kalam.addSpeech(new Speech("Keynote Address at Simon Fraser University", "2008", "tBuWNEbJemo", "Dr. APJ Abdul Kalam", "Distinguished academic address on innovation and sustainable development (13 mins)"));
        kalam.addSpeech(new Speech("Interaction with Children: Vision 2020", "Various", "TckGcxwknYU", "Dr. APJ Abdul Kalam", "15-minute inspirational interaction guiding students toward national development"));
        kalam.addSpeech(new Speech("Leadership and Nation Building Keynote", "2005", "9fz_91hFvzY", "Dr. APJ Abdul Kalam", "22-minute masterclass on managerial integrity and purpose"));
        kalam.addSpeech(new Speech("2003 Presidential Address to Both Houses of Parliament", "2003", "nazqtuB95SY", "Dr. APJ Abdul Kalam", "Full address to the joint session of the Indian Parliament (Digital Sansad)"));
        speakers.add(kalam);

        // =========================================================================
        // 3. PANDIT JAWAHARLAL NEHRU (Official Prasar Bharati Digitized Speeches)
        // =========================================================================
        Speaker nehru = new Speaker("Jawaharlal Nehru", "🇮🇳 India", "JN", Color.parseColor("#1565C0"));
        nehru.addSpeech(new Speech("Tryst with Destiny — Constituent Assembly 1947", "1947", "VnxirE62Yd8", "Jawaharlal Nehru", "Prasar Bharati Archives digitized master audio of the midnight independence declaration (6 mins)"));
        nehru.addSpeech(new Speech("Constituent Assembly Independence Day Address", "1947", "MjM8TR9_oOo", "Jawaharlal Nehru", "Prasar Bharati Archives recording of the morning session of August 15, 1947"));
        nehru.addSpeech(new Speech("1951 Independence Day Red Fort Address", "1951", "otqVETbLlG8", "Jawaharlal Nehru", "Prasar Bharati Archives 43-minute historic address from the ramparts of Red Fort"));
        nehru.addSpeech(new Speech("1948 Independence Day Address to the Nation", "1948", "20EgRoRJxfw", "Jawaharlal Nehru", "27-minute archival address on rebuilding India, communal harmony, and state building"));
        nehru.addSpeech(new Speech("Last In-Depth TV Interview (May 1964)", "1964", "zlTfXWFQYGQ", "Jawaharlal Nehru", "45-minute profound archival broadcast reflecting on history, democracy, and peace"));
        speakers.add(nehru);

        // =========================================================================
        // 4. SACHIN TENDULKAR (Full Wankhede Retirement & Farewell Speeches)
        // =========================================================================
        Speaker sachin = new Speaker("Sachin Tendulkar", "🇮🇳 India", "ST", Color.parseColor("#00897B"));
        sachin.addSpeech(new Speech("Full Farewell Speech at Wankhede Stadium (2013)", "2013", "u1ckD5y2eKo", "Sachin Tendulkar", "The immortal 21-minute farewell speech thanking family, coach Achrekar, teammates, and fans"));
        sachin.addSpeech(new Speech("Wankhede Retirement Address & Ceremony True HD", "2013", "Np-RrpbGvGg", "Sachin Tendulkar", "Full 41-minute master HD recording of the retirement presentation and speech"));
        sachin.addSpeech(new Speech("Complete Farewell Speech & On-Field Farewell", "2013", "xQjp8wPylFs", "Sachin Tendulkar", "Uncut 21-minute address covering his 24-year journey between 22 yards"));
        sachin.addSpeech(new Speech("Farewell Speech & Exclusive Career Reflections", "2013", "7qHqUv_oKHc", "Sachin Tendulkar", "14-minute interview and speech reflecting on his final match and 200 Tests"));
        speakers.add(sachin);

        // =========================================================================
        // 5. LAL BAHADUR SHASTRI (Official Prasar Bharati Archival Addresses)
        // =========================================================================
        Speaker shastri = new Speaker("Lal Bahadur Shastri", "🇮🇳 India", "LS", Color.parseColor("#F57C00"));
        shastri.addSpeech(new Speech("1965 Independence Day Speech — 'Jai Jawan Jai Kisan'", "1965", "R2YNbWXbe9c", "Lal Bahadur Shastri", "Prasar Bharati Archives 35-minute historic Red Fort address rallying the nation"));
        shastri.addSpeech(new Speech("1965 Indo-Pak War: Address to the Nation", "1965", "oAABY_r7dCE", "Lal Bahadur Shastri", "Prasar Bharati Archives 15-minute radio broadcast mobilizing India's self-reliance"));
        shastri.addSpeech(new Speech("Dharti Ka Lal: Archival Speeches & Life (Part 1)", "1965", "H_bX52bMyjg", "Lal Bahadur Shastri", "24-minute archival series from Prasar Bharati featuring authentic voice recordings"));
        shastri.addSpeech(new Speech("Dharti Ka Lal: Archival Speeches & Life (Part 2)", "1965", "s3X6E6D2JHE", "Lal Bahadur Shastri", "25-minute continuation exploring his agricultural reforms and wartime leadership"));
        shastri.addSpeech(new Speech("Life, Speeches, and Legacy of Shastri Ji", "1965", "8oWbo3CNZB4", "Lal Bahadur Shastri", "43-minute comprehensive Prasar Bharati documentary with unedited speeches"));
        speakers.add(shastri);

        // =========================================================================
        // 6. DR. SARVEPALLI RADHAKRISHNAN (Official Presidential Broadcasts)
        // =========================================================================
        Speaker radhakrishnan = new Speaker("Dr. Sarvepalli Radhakrishnan", "🇮🇳 India", "SR", Color.parseColor("#6A1B9A"));
        radhakrishnan.addSpeech(new Speech("1964 Independence Eve Message to the Nation", "1964", "nms_kEsd9Tg", "Dr. Sarvepalli Radhakrishnan", "Prasar Bharati Archives 14-minute presidential address on education, virtue, and statehood"));
        radhakrishnan.addSpeech(new Speech("1965 Message to the Nation during Wartime", "1965", "cDmnNPWgmSM", "Dr. Sarvepalli Radhakrishnan", "11-minute official archival message on moral courage and national solidarity"));
        radhakrishnan.addSpeech(new Speech("1963 Independence Eve Address to the Nation", "1963", "HABwJZlhn-Q", "Dr. Sarvepalli Radhakrishnan", "Prasar Bharati Archives 8-minute address on philosophical heritage and national duty"));
        radhakrishnan.addSpeech(new Speech("1962 Eve of Independence Day Address", "1962", "9LkqldIOxwQ", "Dr. Sarvepalli Radhakrishnan", "Historic 8-minute address marking his first Independence Eve speech as President"));
        radhakrishnan.addSpeech(new Speech("Life & Philosophical Work Documentary", "Various", "HtmAajQgHRM", "Dr. Sarvepalli Radhakrishnan", "19-minute archival study with original voice recordings of his philosophical lectures"));
        speakers.add(radhakrishnan);

        // =========================================================================
        // 7. NETAJI SUBHAS CHANDRA BOSE (Official Archival Addresses)
        // =========================================================================
        Speaker bose = new Speaker("Netaji Subhas Chandra Bose", "🇮🇳 India", "SB", Color.parseColor("#C2185B"));
        bose.addSpeech(new Speech("Historic Speech in Tokyo (1943)", "1943", "8n9c9qdZoVI", "Netaji Subhas Chandra Bose", "Prasar Bharati Archives 19-minute authentic recording of Netaji's address in Tokyo"));
        bose.addSpeech(new Speech("1943 Greater East Asia Conference Address", "1943", "vofeyJ_jnms", "Netaji Subhas Chandra Bose", "12-minute archival speech demanding total self-determination and liberty for India"));
        bose.addSpeech(new Speech("Birth Centenary Archival Speeches (Part 2)", "1944", "NAbal03aYbU", "Netaji Subhas Chandra Bose", "41-minute Prasar Bharati Archives compilation of original INA radio broadcasts"));
        bose.addSpeech(new Speech("Freedom Struggle, INA Strategy & Vision (DD News)", "1943", "8duk-OMqphA", "Netaji Subhas Chandra Bose", "33-minute DD News archival documentary featuring restored audio clips"));
        speakers.add(bose);

        // =========================================================================
        // 8. SARDAR VALLABHBHAI PATEL (Official Prasar Bharati Archival Speeches)
        // =========================================================================
        Speaker patel = new Speaker("Sardar Vallabhbhai Patel", "🇮🇳 India", "VP", Color.parseColor("#BF360C"));
        patel.addSpeech(new Speech("1950 Address to Police Personnel at Delhi", "1950", "BoW78roEsuc", "Sardar Vallabhbhai Patel", "Prasar Bharati Archives 10-minute speech on discipline, integrity, and patriotism"));
        patel.addSpeech(new Speech("1948 Address at Irwin Stadium, New Delhi", "1948", "1LExstiBjWg", "Sardar Vallabhbhai Patel", "12-minute archival voice recording of the Iron Man addressing national security personnel"));
        patel.addSpeech(new Speech("1948 Historic Public Address at Calcutta Maidan", "1948", "_3HFNqforiM", "Sardar Vallabhbhai Patel", "10-minute address resolving post-partition crisis and urging unity among citizens"));
        patel.addSpeech(new Speech("1947 Appeal for Internal Peace & Security", "1947", "bcIpdFEHvj0", "Sardar Vallabhbhai Patel", "9-minute historic radio appeal urging communal harmony and law & order"));
        patel.addSpeech(new Speech("Enduring Relevance of Sardar Patel Memorial", "Various", "wEC064eRcfA", "Sardar Vallabhbhai Patel", "51-minute memorial oration including archival soundbites of Patel's integration speeches"));
        speakers.add(patel);

        // =========================================================================
        // 9. MARTIN LUTHER KING JR. (Full Uncut Historic Speeches)
        // =========================================================================
        Speaker mlk = new Speaker("Martin Luther King Jr.", "🇺🇸 USA", "MK", Color.parseColor("#1976D2"));
        mlk.addSpeech(new Speech("\"I Have a Dream\" — Full Speech Best Restored Audio", "1963", "ARvrvJV4th4", "Martin Luther King Jr.", "Complete 33-minute March on Washington address with pristine remastered audio"));
        mlk.addSpeech(new Speech("\"I Have A Dream\" Restored Full Address", "1963", "8LWuu2Zwsfs", "Martin Luther King Jr.", "17-minute restored master recording of the speech at Lincoln Memorial"));
        mlk.addSpeech(new Speech("\"I've Been To The Mountaintop\" (Final Speech 1968)", "1968", "gC6qxf3b3FI", "Martin Luther King Jr.", "43-minute historic address delivered the day before his assassination (King Center)"));
        mlk.addSpeech(new Speech("\"I Have A Dream\" (Entiversal Full Speech)", "1963", "bNBGvaSHWbY", "Martin Luther King Jr.", "17-minute full speech delivered to 250,000 civil rights marchers"));
        mlk.addSpeech(new Speech("\"I Have a Dream!\" (English Speeches with Subtitles)", "1963", "qHc3FY9il1s", "Martin Luther King Jr.", "8-minute iconic climax with clear English subtitles"));
        speakers.add(mlk);

        // =========================================================================
        // 10. WINSTON CHURCHILL (Full Historic Wartime Addresses)
        // =========================================================================
        Speaker churchill = new Speaker("Winston Churchill", "🇬🇧 United Kingdom", "WC", Color.parseColor("#5D4037"));
        churchill.addSpeech(new Speech("\"Their Finest Hour\" — Complete Address (June 1940)", "1940", "jB5wZtV1MWM", "Winston Churchill", "30-minute full wartime speech to the House of Commons during the Battle of France"));
        churchill.addSpeech(new Speech("\"We Shall Never Surrender\" (We Shall Fight on Beaches)", "1940", "s_LncVnecLA", "Winston Churchill", "12-minute full iconic address delivered following the Dunkirk evacuation"));
        churchill.addSpeech(new Speech("\"Blood, Toil, Tears and Sweat\" (May 13, 1940)", "1940", "80_HXIHa724", "Winston Churchill", "First speech as Prime Minister to Parliament outlining resolute war policy (6 mins)"));
        churchill.addSpeech(new Speech("\"We Shall Never Surrender\" (Parliamentary Master)", "1940", "CXIrnU7Y_RU", "Winston Churchill", "6-minute restored audio recording from Focus Features archives"));
        churchill.addSpeech(new Speech("\"Never Surrender\" Motivational Address", "1940", "0JQfIldcOSw", "Winston Churchill", "5-minute address rallying British spirit and civilian morale"));
        speakers.add(churchill);

        // =========================================================================
        // 11. JOHN F. KENNEDY (Official Full Addresses & Speeches)
        // =========================================================================
        Speaker jfk = new Speaker("John F. Kennedy", "🇺🇸 USA", "JK", Color.parseColor("#0288D1"));
        jfk.addSpeech(new Speech("1963 American University \"Peace Speech\" (C-SPAN)", "1963", "0fkKnfk4k40", "John F. Kennedy", "C-SPAN 27-minute complete commencement address outlining world peace & nuclear test ban"));
        jfk.addSpeech(new Speech("Address to American Newspaper Publishers (Secret Societies)", "1961", "cgHGg8PiAqo", "John F. Kennedy", "20-minute full address at the Waldorf-Astoria on free press and open society"));
        jfk.addSpeech(new Speech("Freedom of Information & Society (Long Version)", "1961", "pfzJaLXujTE", "John F. Kennedy", "20-minute speech emphasizing that an informed citizenry is the defense of liberty"));
        jfk.addSpeech(new Speech("JFK's 10 Best Speeches (Including Moon Speech)", "1962", "6DbhTwahqPg", "John F. Kennedy", "7-minute highlights including 'We choose to go to the moon' and 'Ask not'"));
        speakers.add(jfk);

        // =========================================================================
        // 12. NELSON MANDELA (Official Full Addresses & Speeches)
        // =========================================================================
        Speaker mandela = new Speaker("Nelson Mandela", "🇿🇦 South Africa", "NM", Color.parseColor("#00796B"));
        mandela.addSpeech(new Speech("Freedom and Justice (English Speeches)", "1994", "w42rHdvFpVM", "Nelson Mandela", "14-minute address with subtitles celebrating democratic transition in South Africa"));
        mandela.addSpeech(new Speech("1994 Presidential Inauguration Address (SABC News)", "1994", "pJiXu4q__VU", "Nelson Mandela", "Official SABC 9-minute broadcast of Mandela taking oath as South Africa's first Black president"));
        mandela.addSpeech(new Speech("Address at Harvard University on Reconciliation", "1998", "6D2YSOGpen0", "Nelson Mandela", "23-minute speech on forgiveness, truth and reconciliation, and constitutional democracy"));
        mandela.addSpeech(new Speech("Address Upon Release from Prison (11 Feb 1990)", "1990", "6lQAc6Y_A48", "Nelson Mandela", "8-minute historic address to the world immediately after 27 years of imprisonment"));
        mandela.addSpeech(new Speech("Global Town Hall on Human Dignity and Freedom", "1990", "WcQIEIRLU1Y", "Nelson Mandela", "73-minute landmark town hall interview with the international community in New York"));
        speakers.add(mandela);

        // =========================================================================
        // 13. ADOLF HITLER (Historical Educational Speeches with Subtitles)
        // =========================================================================
        Speaker hitler = new Speaker("Adolf Hitler (Historical)", "🇩🇪 Germany", "AH", Color.parseColor("#455A64"));
        hitler.addSpeech(new Speech("Election Speech in Göttingen 1932 (English Subtitles)", "1932", "wi0iKFFBKc0", "Adolf Hitler", "20-minute historical campaign address with verified English subtitles (German Speeches)"));
        hitler.addSpeech(new Speech("Election Speech in Eberswalde 1932 (English Subtitles)", "1932", "uq7lZJwc6_g", "Adolf Hitler", "13-minute archival rally footage from July 1932 with English translations"));
        hitler.addSpeech(new Speech("Address at Siemens Dynamo Factory 1933 (Subtitled)", "1933", "4JPGziYm6Oc", "Adolf Hitler", "14-minute historical address with English subtitles for academic study"));
        speakers.add(hitler);

        // =========================================================================
        // 14. BARACK OBAMA (Official Full DNC & Presidential Addresses)
        // =========================================================================
        Speaker obama = new Speaker("Barack Obama", "🇺🇸 USA", "BO", Color.parseColor("#303F9F"));
        obama.addSpeech(new Speech("2012 DNC Presidential Address (Full Speech)", "2012", "2rl8Ou84s5U", "Barack Obama", "40-minute complete speech accepting the nomination at Democratic National Convention"));
        obama.addSpeech(new Speech("Sen. Barack Obama's Full 2004 DNC Keynote (C-SPAN)", "2004", "ato7BtisXzE", "Barack Obama", "50-minute complete C-SPAN coverage of the breakout 'One America' keynote"));
        obama.addSpeech(new Speech("President Obama Addresses the People of India (White House)", "2015", "ZQdAmVrzgIQ", "Barack Obama", "34-minute official White House video of town hall address at Siri Fort, New Delhi"));
        obama.addSpeech(new Speech("2004 DNC Keynote: 'There is Not a Liberal America'", "2004", "eWynt87PaJ0", "Barack Obama", "19-minute remastered video of the speech that launched his national career"));
        obama.addSpeech(new Speech("Commencement Address: Ignorance is NOT a Virtue", "2016", "S4lTtvlFvyk", "Barack Obama", "32-minute address with English subtitles urging intellectual honesty and civic engagement"));
        speakers.add(obama);

        // =========================================================================
        // 15. SWAMI VIVEKANANDA (Full Uncut Addresses & World Parliament)
        // =========================================================================
        Speaker vivekananda = new Speaker("Swami Vivekananda", "🇮🇳 India", "SV", Color.parseColor("#C51162"));
        vivekananda.addSpeech(new Speech("1893 Chicago Parliament (Full Speech with Subtitles)", "1893", "vPDQOB7pRRM", "Swami Vivekananda", "29-minute complete English narration with subtitles of the landmark Chicago Parliament address"));
        vivekananda.addSpeech(new Speech("World's Parliament of Religions Commemoration", "1893", "KAQMDuuN3Js", "Swami Vivekananda", "45-minute comprehensive audio archive of his lectures on tolerance and universal religion"));
        vivekananda.addSpeech(new Speech("Chicago Speech in Hindi (Full Uncut Audio)", "1893", "cdTy8e7XMxA", "Swami Vivekananda", "46-minute complete uncut audio recording of the Chicago World Parliament address"));
        vivekananda.addSpeech(new Speech("Sisters & Brothers of America (Full Narration in Hindi)", "1893", "AzLUgnXlecU", "Swami Vivekananda", "13-minute Hindi narration of the famous opening and response at Chicago"));
        speakers.add(vivekananda);

        return speakers;
    }

    public static List<Object> getFilteredList(String query) {
        List<Object> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase().trim();
        if (lowerQuery.isEmpty()) {
            for (Speaker speaker : getAllSpeakers()) {
                results.add(speaker);
                if (speaker.isExpanded()) {
                    results.addAll(speaker.getSpeeches());
                }
            }
            return results;
        }
        for (Speaker speaker : getAllSpeakers()) {
            boolean speakerMatches = speaker.getName().toLowerCase().contains(lowerQuery)
                    || speaker.getCountry().toLowerCase().contains(lowerQuery);
            List<Speech> matchingSpeeches = new ArrayList<>();
            for (Speech speech : speaker.getSpeeches()) {
                if (speech.getTitle().toLowerCase().contains(lowerQuery)
                        || speech.getYear().toLowerCase().contains(lowerQuery)
                        || speakerMatches) {
                    matchingSpeeches.add(speech);
                }
            }
            if (!matchingSpeeches.isEmpty()) {
                results.add(speaker);
                results.addAll(matchingSpeeches);
            }
        }
        return results;
    }

    public static List<Object> buildDisplayList() {
        List<Object> items = new ArrayList<>();
        for (Speaker speaker : getAllSpeakers()) {
            items.add(speaker);
            if (speaker.isExpanded()) {
                items.addAll(speaker.getSpeeches());
            }
        }
        return items;
    }

    public static void resetCache() {
        speakers = null;
    }
}
