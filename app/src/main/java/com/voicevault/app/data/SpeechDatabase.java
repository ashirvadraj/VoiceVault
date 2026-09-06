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
        // 1. ATAL BIHARI VAJPAYEE (16 Speeches & Recitations)
        // =========================================================================
        Speaker vajpayee = new Speaker("Atal Bihari Vajpayee", "🇮🇳 India", "AV", Color.parseColor("#E65100"));
        vajpayee.addSpeech(new Speech("No-Confidence Motion — \"Sarkarein aayengi jayengi\"", "1996", "kYv9d7tQW98", "Atal Bihari Vajpayee", "His most famous parliamentary speech: 'Sarkarein aayengi, jayengi, partiyan banengi, bigadengi, magar yeh desh rehna chahiye'"));
        vajpayee.addSpeech(new Speech("1996 Resignation Speech after 13 Days", "1996", "0kH84wWJ7yU", "Atal Bihari Vajpayee", "Historic resignation address in Lok Sabha stepping down with dignity"));
        vajpayee.addSpeech(new Speech("Historic Parliament Speech — Lok Sabha", "1996", "F3S1W-sW9iE", "Atal Bihari Vajpayee", "Passionate address on democratic traditions and parliamentary integrity"));
        vajpayee.addSpeech(new Speech("UNGA Speech in Hindi (First Ever)", "1977", "UmYWaehXw-4", "Atal Bihari Vajpayee", "The landmark first Hindi address delivered at the United Nations General Assembly"));
        vajpayee.addSpeech(new Speech("UN Speech — Hindi at the United Nations", "1977", "5Vz5Y-3L1pA", "Atal Bihari Vajpayee", "Archival recording of the legendary UN General Assembly address"));
        vajpayee.addSpeech(new Speech("Pokhran Nuclear Test Address to Nation", "1998", "i9Y1I8tX5tM", "Atal Bihari Vajpayee", "Historic prime ministerial declaration after Operation Shakti underground nuclear tests"));
        vajpayee.addSpeech(new Speech("Speech on Pokhran Tests in Parliament", "1998", "R-k8yY1Pz6k", "Atal Bihari Vajpayee", "Defiant parliamentary debate articulating India's sovereign defense posture"));
        vajpayee.addSpeech(new Speech("Kargil War Address — \"Hum Shanti Chahte Hain\"", "1999", "F21lstnKU7m", "Atal Bihari Vajpayee", "Definitive address to the armed forces and nation during the Kargil conflict"));
        vajpayee.addSpeech(new Speech("Lahore Bus Diplomacy Address", "1999", "pBLyaaq8xcU", "Atal Bihari Vajpayee", "Historic address at Minar-e-Pakistan during the Delhi-Lahore peace initiative"));
        vajpayee.addSpeech(new Speech("Independence Day Address from Red Fort", "2003", "ZbSDNXrao1U", "Atal Bihari Vajpayee", "Speech from the ramparts of Red Fort outlining national progress and peace"));
        vajpayee.addSpeech(new Speech("Parliament Debate on Article 370 & Kashmir", "1994", "EaTTNF4eaof", "Atal Bihari Vajpayee", "Powerful speech on the constitutional and emotional integration of Kashmir"));
        vajpayee.addSpeech(new Speech("Poem Recitation: \"Geet Naya Gaata Hoon\"", "Various", "GHxTBko8OBo", "Atal Bihari Vajpayee", "Vajpayee reciting his immortal poem of optimism and resilience"));
        vajpayee.addSpeech(new Speech("Poem Recitation: \"Kadam Milakar Chalna Hoga\"", "Various", "FWLtACgoNQd", "Atal Bihari Vajpayee", "Vajpayee reciting his beloved national rallying poem"));
        vajpayee.addSpeech(new Speech("1971 Bangladesh War & Tribute to Indira Gandhi", "1971", "bK9yL_7O0wA", "Atal Bihari Vajpayee", "Historic parliamentary tribute following the liberation of Bangladesh"));
        vajpayee.addSpeech(new Speech("Best Speeches Compilation (Sansad TV)", "Various", "rWl-f8Z1hC8", "Atal Bihari Vajpayee", "Curated master collection of parliamentary orations"));
        vajpayee.addSpeech(new Speech("Samagrah — A National Tribute", "Various", "iA9tW_O9k1Y", "Atal Bihari Vajpayee", "Exhaustive tribute capturing his iconic public oratory"));
        speakers.add(vajpayee);

        // =========================================================================
        // 2. DR. APJ ABDUL KALAM (12 Speeches & Addresses)
        // =========================================================================
        Speaker kalam = new Speaker("Dr. APJ Abdul Kalam", "🇮🇳 India", "AK", Color.parseColor("#2E7D32"));
        kalam.addSpeech(new Speech("Three Visions for India — Freedom, Development, Strength", "2011", "GR0dzCx_q34", "Dr. APJ Abdul Kalam", "Iconic speech at IIT Hyderabad outlining his 3 core visions for the nation"));
        kalam.addSpeech(new Speech("Leadership Lesson: Prof. Satish Dhawan & Handling Failure", "Various", "FiiqzwAPmdL", "Dr. APJ Abdul Kalam", "Legendary personal story on leadership, accountability, and handling failure"));
        kalam.addSpeech(new Speech("Culture of Excellence — 19th ALNC Oration", "2005", "_BnMwqSBqdQ", "Dr. APJ Abdul Kalam", "Landmark presidential oration on fostering a national culture of excellence"));
        kalam.addSpeech(new Speech("Speech at the European Parliament", "2007", "rJbP2Y_1sKA", "Dr. APJ Abdul Kalam", "Historic address proposing a global partnership for energy and space development"));
        kalam.addSpeech(new Speech("Address to IIT Students on Innovation & Creative Minds", "2014", "59rEr7A-LLI", "Dr. APJ Abdul Kalam", "Roadmap for engineering graduates to become job creators and innovators"));
        kalam.addSpeech(new Speech("\"Dream, Dream, Dream\" — Youth Address", "Various", "TF0U1p_Xq3Y", "Dr. APJ Abdul Kalam", "His most quoted address inspiring students to transform dreams into action"));
        kalam.addSpeech(new Speech("Vision 2020 — India a Developed Nation", "2002", "bKZfPp_X0iY", "Dr. APJ Abdul Kalam", "Action plan for science, infrastructure, and socioeconomic growth"));
        kalam.addSpeech(new Speech("Last Speech at IIM Shillong", "2015", "xqEFMn19XrM", "Dr. APJ Abdul Kalam", "His final lecture delivered to young students just before his passing"));
        kalam.addSpeech(new Speech("Wings of Fire — Audiobook Excerpt & Narration", "Various", "T3PFcBn_MCI", "Dr. APJ Abdul Kalam", "Reflections from his autobiography on adversity and scientific triumph"));
        kalam.addSpeech(new Speech("How to Become Unique — Address to Children", "Various", "P9u8K_7j0rQ", "Dr. APJ Abdul Kalam", "Interactive speech teaching youth 4 essentials: aim high, acquire knowledge, work hard, persevere"));
        kalam.addSpeech(new Speech("Address on Science, Society, and Peace", "Various", "D7m8yP_4l0A", "Dr. APJ Abdul Kalam", "Speech on utilizing modern technology for poverty eradication"));
        kalam.addSpeech(new Speech("Most Inspiring Motivational Compilation", "Various", "L-7l5HFQbpA", "Dr. APJ Abdul Kalam", "Curated master audio of Dr. Kalam's greatest advice to young minds"));
        speakers.add(kalam);

        // =========================================================================
        // 3. PANDIT JAWAHARLAL NEHRU (8 Speeches & Broadcasts)
        // =========================================================================
        Speaker nehru = new Speaker("Jawaharlal Nehru", "🇮🇳 India", "JN", Color.parseColor("#1565C0"));
        nehru.addSpeech(new Speech("Tryst with Destiny (Original Midnight Address)", "1947", "TuhtH8j4stw", "Jawaharlal Nehru", "Delivered on midnight of August 14-15, 1947: 'Long years ago we made a tryst with destiny...'"));
        nehru.addSpeech(new Speech("Tryst with Destiny — Prasar Bharati Archival Audio", "1947", "kYJzO4tBf1U", "Jawaharlal Nehru", "Digitized original sound recording from the Constituent Assembly"));
        nehru.addSpeech(new Speech("Tryst with Destiny — Hindi Address (DD Archives)", "1947", "5Vz6K-H6R7M", "Jawaharlal Nehru", "Hindi translation address broadcast to the nation at independence"));
        nehru.addSpeech(new Speech("\"The Light Has Gone Out of Our Lives\" — Gandhi Eulogy", "1948", "GvvxV3pHsOV", "Jawaharlal Nehru", "Emotional radio broadcast announcing the assassination of Mahatma Gandhi"));
        nehru.addSpeech(new Speech("Constituent Assembly Election of First President", "1950", "8yU7b5rXJ8c", "Jawaharlal Nehru", "Speech on the unanimous election of Dr. Rajendra Prasad as India's first President"));
        nehru.addSpeech(new Speech("1951 Independence Day Speech at Red Fort", "1951", "gT8wT-u1g1w", "Jawaharlal Nehru", "Address detailing early post-independence challenges and planning"));
        nehru.addSpeech(new Speech("1960 Independence Day Red Fort Address", "1960", "7uKzXbN_g6Q", "Jawaharlal Nehru", "Reflections on industrial growth and international non-alignment"));
        nehru.addSpeech(new Speech("Asian Relations Conference Opening Address", "1947", "z9O-3J_k8iI", "Jawaharlal Nehru", "Historic speech asserting Asia's independence and resurgence"));
        speakers.add(nehru);

        // =========================================================================
        // 4. LAL BAHADUR SHASTRI (5 Speeches)
        // =========================================================================
        Speaker shastri = new Speaker("Lal Bahadur Shastri", "🇮🇳 India", "LS", Color.parseColor("#F57C00"));
        shastri.addSpeech(new Speech("\"Jai Jawan, Jai Kisan\" Iconic Rally Address", "1965", "3WKEK5FhfJA", "Lal Bahadur Shastri", "The legendary slogan galvanizing soldiers on the border and farmers in the field"));
        shastri.addSpeech(new Speech("Address to the Nation during 1965 War", "1965", "9pQoZVRfZKA", "Lal Bahadur Shastri", "Sober and determined radio address rallying the country during the conflict"));
        shastri.addSpeech(new Speech("Prasar Bharati Archival Speech Recording", "1965", "RKwlUGaSD3I", "Lal Bahadur Shastri", "Official archival recording from the public broadcasts of Shastri ji"));
        shastri.addSpeech(new Speech("Rare Speeches & Radio Broadcasts Collection", "Various", "l0fBY8xfHHQ", "Lal Bahadur Shastri", "Curated selection of speeches highlighting his simplicity and resolve"));
        shastri.addSpeech(new Speech("Tashkent Declaration Statement", "1966", "T_84yL_9k1A", "Lal Bahadur Shastri", "Final public statement before his untimely demise in Tashkent"));
        speakers.add(shastri);

        // =========================================================================
        // 5. DR. SARVEPALLI RADHAKRISHNAN (5 Speeches)
        // =========================================================================
        Speaker radhakrishnan = new Speaker("Dr. Sarvepalli Radhakrishnan", "🇮🇳 India", "SR", Color.parseColor("#6A1B9A"));
        radhakrishnan.addSpeech(new Speech("On Education, Teachers & National Progress", "1962", "3Nh33FK59fE", "Dr. Sarvepalli Radhakrishnan", "Foundational speech articulating why his birthday is commemorated as Teachers' Day"));
        radhakrishnan.addSpeech(new Speech("Presidential Address to the Nation", "1963", "0vqfxdJMNdg", "Dr. Sarvepalli Radhakrishnan", "Reflections on democratic conscience, duty, and spiritual traditions"));
        radhakrishnan.addSpeech(new Speech("Philosophy of Life and Human Destiny", "Various", "E1JCr1_3xKs", "Dr. Sarvepalli Radhakrishnan", "Profound philosophical discourse examining Eastern and Western thought"));
        radhakrishnan.addSpeech(new Speech("Discourse on the Bhagavad Gita & Indian Thought", "Various", "S4r9wK_1a8Y", "Dr. Sarvepalli Radhakrishnan", "Exposition on universal ethics and the Gita's philosophy of detached action"));
        radhakrishnan.addSpeech(new Speech("Address to the UNESCO General Conference", "Various", "U8n2kP_6z0W", "Dr. Sarvepalli Radhakrishnan", "Philosophical appeal for global peace through moral and spiritual education"));
        speakers.add(radhakrishnan);

        // =========================================================================
        // 6. NETAJI SUBHAS CHANDRA BOSE (3 Speeches)
        // =========================================================================
        Speaker bose = new Speaker("Netaji Subhas Chandra Bose", "🇮🇳 India", "SB", Color.parseColor("#C2185B"));
        bose.addSpeech(new Speech("\"Give Me Blood, and I Will Give You Freedom\"", "1944", "kYJ-w24039I", "Netaji Subhas Chandra Bose", "Historic speech delivered in Burma inspiring the Indian National Army (INA)"));
        bose.addSpeech(new Speech("\"Dilli Chalo\" (March to Delhi) Rally Call", "1943", "V0x6gVv_4A4", "Netaji Subhas Chandra Bose", "Galvanizing battle cry rallying the INA troops for the liberation of the motherland"));
        bose.addSpeech(new Speech("Azad Hind Radio Broadcast to the People of India", "1942", "yY6m59j7z2E", "Netaji Subhas Chandra Bose", "Radio address calling upon Indians to rise up against colonial rule"));
        speakers.add(bose);

        // =========================================================================
        // 7. SARDAR VALLABHBHAI PATEL (3 Speeches)
        // =========================================================================
        Speaker patel = new Speaker("Sardar Vallabhbhai Patel", "🇮🇳 India", "VP", Color.parseColor("#BF360C"));
        patel.addSpeech(new Speech("Historic Address on National Unity — 12 Feb 1949", "1949", "KUJFRe4LqQI", "Sardar Vallabhbhai Patel", "Archival audio excerpt on national integration and civic responsibility"));
        patel.addSpeech(new Speech("Address to the Nation — 12 October 1947", "1947", "kYJ_tN7Q5-8", "Sardar Vallabhbhai Patel", "Speech dealing with refugee rehabilitation and internal security"));
        patel.addSpeech(new Speech("\"Steel Frame of India\" — Civil Services Address", "1947", "mD6P-q0U8s0", "Sardar Vallabhbhai Patel", "Foundational speech to the first batch of Indian Administrative Service officers"));
        speakers.add(patel);

        // =========================================================================
        // 8. SACHIN TENDULKAR (5 Speeches & Farewell Addresses)
        // =========================================================================
        Speaker sachin = new Speaker("Sachin Tendulkar", "🇮🇳 India", "ST", Color.parseColor("#00897B"));
        sachin.addSpeech(new Speech("Emotional Farewell Speech at Wankhede Stadium", "2013", "9PW1E3T9o8s", "Sachin Tendulkar", "The immortal 20-minute retirement address: 'My life, between 22 yards for 24 years... Sachin, Sachin will reverberate in my ears till my last breath'"));
        sachin.addSpeech(new Speech("Retirement Address — Full Live Broadcast", "2013", "R9N3M4tWd2E", "Sachin Tendulkar", "Complete unedited live broadcast of his farewell address touching coaches, family, and fans"));
        sachin.addSpeech(new Speech("Sports Vision & \"Right to Play\" Address", "2017", "GTr2huBWzki", "Sachin Tendulkar", "National address on transforming India from a sport-loving nation into a sport-playing nation"));
        sachin.addSpeech(new Speech("ICC Cricket Hall of Fame Induction Speech", "2019", "GNrsM-0oPuT", "Sachin Tendulkar", "Honouring the game, his childhood coaches, and the international cricket fraternity"));
        sachin.addSpeech(new Speech("2011 World Cup Victory & Wankhede Lap of Honour", "2011", "QG-ChzE43U2", "Sachin Tendulkar", "Reflections on fulfilling his 22-year childhood dream of lifting the World Cup for India"));
        speakers.add(sachin);

        // =========================================================================
        // 9. MARTIN LUTHER KING JR. (5 Speeches)
        // =========================================================================
        Speaker mlk = new Speaker("Martin Luther King Jr.", "🇺🇸 USA", "MK", Color.parseColor("#1976D2"));
        mlk.addSpeech(new Speech("\"I Have a Dream\"", "1963", "vP4iYBbastw", "Martin Luther King Jr.", "Historic address at the March on Washington for Jobs and Freedom"));
        mlk.addSpeech(new Speech("\"I've Been to the Mountaintop\"", "1968", "IDl84bBJbqQ", "Martin Luther King Jr.", "His poignant final speech delivered the day before his assassination in Memphis"));
        mlk.addSpeech(new Speech("Beyond Vietnam — A Time to Break Silence", "1967", "AJhgXKGldUk", "Martin Luther King Jr.", "Powerful moral stand against war delivered at Riverside Church"));
        mlk.addSpeech(new Speech("\"The Other America\" Speech", "1967", "dOWDtDUKieU", "Martin Luther King Jr.", "Address at Stanford University examining economic inequality and racial justice"));
        mlk.addSpeech(new Speech("\"How Long, Not Long\" (Our God is Marching On)", "1965", "T549Io8aD24", "Martin Luther King Jr.", "Speech on the steps of the Alabama State Capitol after the Selma March"));
        speakers.add(mlk);

        // =========================================================================
        // 9. WINSTON CHURCHILL (5 Speeches)
        // =========================================================================
        Speaker churchill = new Speaker("Winston Churchill", "🇬🇧 United Kingdom", "WC", Color.parseColor("#5D4037"));
        churchill.addSpeech(new Speech("\"Blood, Toil, Tears and Sweat\"", "1940", "8TlkN-dtU9M", "Winston Churchill", "First speech as Prime Minister to the House of Commons during wartime"));
        churchill.addSpeech(new Speech("\"We Shall Fight on the Beaches\"", "1940", "MKinCWn05s8", "Winston Churchill", "Iconic speech to Parliament after the Dunkirk evacuation"));
        churchill.addSpeech(new Speech("\"Their Finest Hour\"", "1940", "G4BVzYGeF0M", "Winston Churchill", "Inspiring the British Commonwealth during the Battle of Britain"));
        churchill.addSpeech(new Speech("\"We Shall Never Surrender\"", "1940", "N3tG6t70z_c", "Winston Churchill", "Defiant wartime declaration rallying British resistance against the Axis powers"));
        churchill.addSpeech(new Speech("\"Iron Curtain\" (Sinews of Peace) Speech", "1946", "uG48f1j7i5w", "Winston Churchill", "Address at Westminster College marking the start of the Cold War era"));
        speakers.add(churchill);

        // =========================================================================
        // 10. JOHN F. KENNEDY (3 Speeches)
        // =========================================================================
        Speaker jfk = new Speaker("John F. Kennedy", "🇺🇸 USA", "JK", Color.parseColor("#0288D1"));
        jfk.addSpeech(new Speech("Inaugural Address — \"Ask Not What Your Country Can Do For You\"", "1961", "PEC1C4p0k3E", "John F. Kennedy", "Historic 1961 inauguration speech challenging citizens to civic service"));
        jfk.addSpeech(new Speech("\"We Choose to Go to the Moon\" (Rice University)", "1962", "th5A6Px2ZAg", "John F. Kennedy", "Landmark speech establishing America's commitment to landing a man on the moon"));
        jfk.addSpeech(new Speech("\"Ich bin ein Berliner\" (I am a Berliner)", "1963", "56V6r26dU30", "John F. Kennedy", "Iconic speech at Rudolph Wilde Platz in West Berlin highlighting democracy"));
        speakers.add(jfk);

        // =========================================================================
        // 11. NELSON MANDELA (5 Speeches)
        // =========================================================================
        Speaker mandela = new Speaker("Nelson Mandela", "🇿🇦 South Africa", "NM", Color.parseColor("#00796B"));
        mandela.addSpeech(new Speech("\"I Am Prepared to Die\" — Rivonia Trial", "1964", "g5OJ205MdKI", "Nelson Mandela", "Three-hour defense speech from the dock before his life imprisonment"));
        mandela.addSpeech(new Speech("Address to the Joint Session of U.S. Congress", "1990", "e4h6yL_7T48", "Nelson Mandela", "Triumphant speech shortly after being released after 27 years in prison"));
        mandela.addSpeech(new Speech("Presidential Inauguration Address", "1994", "pvgfpeupj64", "Nelson Mandela", "Declaration as first democratically elected President of a free South Africa"));
        mandela.addSpeech(new Speech("\"Sport Has the Power to Change the World\"", "2000", "xW3_9S08_2k", "Nelson Mandela", "Keynote address at the inaugural Laureus World Sports Awards in Monaco"));
        mandela.addSpeech(new Speech("\"Make Poverty History\" — Trafalgar Square", "2005", "p9cfl8Z7ZzU", "Nelson Mandela", "Passionate appeal to world leaders to overcome poverty as an act of justice"));
        speakers.add(mandela);

        // =========================================================================
        // 12. ADOLF HITLER (Historical Archive - 4 Speeches)
        // =========================================================================
        Speaker hitler = new Speaker("Adolf Hitler (Historical)", "🇩🇪 Germany", "AH", Color.parseColor("#455A64"));
        hitler.addSpeech(new Speech("Sportpalast Total War Speech (Subtitled Archive)", "1943", "EV9kyocogKo", "Adolf Hitler", "Historical archival footage of the 1943 Berlin Sportpalast rally"));
        hitler.addSpeech(new Speech("Reichstag Address on Outbreak of War (Subtitled)", "1939", "FJ3N_2r6R-o", "Adolf Hitler", "Address to the German Reichstag on September 1, 1939"));
        hitler.addSpeech(new Speech("1936 Berlin Olympic Games Address", "1936", "K4w32_oX94A", "Adolf Hitler", "Historical footage of opening the 1936 Summer Olympics in Berlin"));
        hitler.addSpeech(new Speech("Operation Barbarossa Announcement", "1941", "M9Y6W_51X9Q", "Adolf Hitler", "Archival recording announcing the invasion of the Soviet Union"));
        speakers.add(hitler);

        // =========================================================================
        // 13. BARACK OBAMA (3 Speeches)
        // =========================================================================
        Speaker obama = new Speaker("Barack Obama", "🇺🇸 USA", "BO", Color.parseColor("#303F9F"));
        obama.addSpeech(new Speech("\"Yes We Can\" — 2008 Election Night Victory", "2008", "CnwJy9mSMR8", "Barack Obama", "Victory speech in Chicago's Grant Park after winning the 2008 Presidential election"));
        obama.addSpeech(new Speech("2004 DNC Keynote Address — \"One America\"", "2004", "ueNZ_W4pC6s", "Barack Obama", "Breakout speech arguing there is no liberal or conservative America, only the United States"));
        obama.addSpeech(new Speech("Farewell Address to the Nation", "2017", "paHYyv3_jKo", "Barack Obama", "Final presidential address in Chicago on civic participation and democracy"));
        speakers.add(obama);

        // =========================================================================
        // 14. SWAMI VIVEKANANDA (3 Speeches & Lectures)
        // =========================================================================
        Speaker vivekananda = new Speaker("Swami Vivekananda", "🇮🇳 India", "SV", Color.parseColor("#C51162"));
        vivekananda.addSpeech(new Speech("Chicago Address (1893) — Full Narration", "1893", "6BqOnmhIxVE", "Swami Vivekananda", "Full archival narration of the landmark address at the World's Parliament of Religions"));
        vivekananda.addSpeech(new Speech("\"Sisters and Brothers of America\" Opening Speech", "1893", "0C1vMEbM8Xo", "Swami Vivekananda", "The electrifying opening greeting that received a two-minute standing ovation"));
        vivekananda.addSpeech(new Speech("Paper on Hinduism — World Parliament of Religions", "1893", "V3k8wP_91zA", "Swami Vivekananda", "Exposition on universal toleration and oneness of spiritual truth"));
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
