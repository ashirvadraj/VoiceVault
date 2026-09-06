# Reusable AI Prompt: Building "VoiceVault" Android App

Here is the updated, comprehensive prompt you can provide to any AI coding assistant (or use yourself) to build the complete Android APK for listening to iconic historical speeches:

---

```markdown
You are an expert Android developer. Build a complete, production-ready Android APK named **"VoiceVault"** that allows users to explore, search, and listen to iconic historic speeches by world leaders, historical giants, and cultural icons.

### Requirements:

1. **Target Speakers & Speeches Database (80+ Speeches):**
   Curate and embed a structured catalog with verified audio/video streams (via YouTube IFrame player IDs) and detailed historical annotations:
   
   - **Atal Bihari Vajpayee (16 Speeches & Poems):**
     - 1996 No-Confidence Motion Speech ("Sarkarein aayengi, jayengi, lekin yeh desh rehna chahiye")
     - 1996 13-Day Government Resignation Address
     - Historic Lok Sabha Parliamentary Addresses
     - 1977 First Ever Address in Hindi at the UN General Assembly
     - 1998 Address to the Nation after Pokhran-II Nuclear Tests
     - 1998 Parliamentary Debate on Nuclear Defense
     - 1999 Kargil Conflict Address to the Nation ("Hum Shanti Chahte Hain")
     - 1999 Lahore Peace Bus Diplomacy Address at Minar-e-Pakistan
     - 2003 Independence Day Red Fort Address
     - 1994 Parliamentary Debate on Article 370 & Kashmir Integration
     - 1971 Bangladesh Liberation War parliamentary address honoring Indira Gandhi
     - Personal Poem Recitations: "Geet Naya Gaata Hoon" and "Kadam Milakar Chalna Hoga"
     - Sansad TV Best Speeches compilation and Samagrah National Tribute

   - **Dr. A. P. J. Abdul Kalam (12 Speeches & Lectures):**
     - "Three Visions for India" (Freedom, Development, Strength - IIT Hyderabad 2011)
     - Leadership & Handling Failure (The iconic Prof. Satish Dhawan SLV-3 story)
     - "Culture of Excellence" (19th ALNC Day Oration 2005)
     - Historic 2007 Address at the European Parliament
     - Address to IIT Students on Creative Minds and Innovation (2014)
     - "Dream, Dream, Dream" youth address
     - Vision 2020: India a Developed Nation (2002)
     - His Final Lecture at IIM Shillong (2015)
     - "Wings of Fire" audiobook excerpt and personal reflections
     - "How to Become Unique" — 4 rules for young minds
     - Addresses on Science, Society, and Eradication of Poverty

   - **Pandit Jawaharlal Nehru (8 Speeches & Broadcasts):**
     - "Tryst with Destiny" (August 14-15, 1947 Midnight Independence Address)
     - "Tryst with Destiny" (Prasar Bharati digitized sound recording)
     - "Tryst with Destiny" (DD Archives Hindi broadcast)
     - "The Light Has Gone Out of Our Lives" (January 30, 1948 Mahatma Gandhi Eulogy)
     - 1950 Constituent Assembly Address on the First President of India
     - 1951 Independence Day Red Fort Address
     - 1960 Independence Day Red Fort Address on Non-Alignment and Industrial Progress
     - 1947 Asian Relations Conference Opening Address

   - **Sachin Tendulkar (5 Speeches & Farewell Addresses):**
     - Emotional 20-minute Farewell Address at Wankhede Stadium (Nov 16, 2013: "My life, between 22 yards for 24 years... Sachin, Sachin will reverberate in my ears till my last breath")
     - Complete Unedited Live Broadcast of Retirement Address
     - "Sports Vision & Right to Play" (National address on transforming India into a sports-playing nation)
     - ICC Cricket Hall of Fame Induction Speech (2019)
     - 2011 World Cup Triumph & Wankhede Lap of Honour reflections

   - **Lal Bahadur Shastri (5 Speeches):**
     - "Jai Jawan, Jai Kisan" Iconic Rally Address (1965)
     - Address to the Nation during 1965 War
     - Prasar Bharati Archival Speech Recording
     - Rare Radio Broadcasts Collection
     - Tashkent Declaration Statement (1966)

   - **Dr. Sarvepalli Radhakrishnan (5 Speeches):**
     - On Education, Teachers & National Progress (Teachers' Day 1962)
     - Presidential Address to the Nation (1963)
     - Philosophy of Life and Human Destiny
     - Discourse on Bhagavad Gita & Indian Thought
     - Address to the UNESCO General Conference

   - **Netaji Subhas Chandra Bose (3 Speeches):**
     - "Give Me Blood, and I Will Give You Freedom" (Tokyo/Burma 1944)
     - "Dilli Chalo" (March to Delhi) INA Rally Call (1943)
     - Azad Hind Radio Broadcast to the People of India (1942)

   - **Sardar Vallabhbhai Patel (3 Speeches):**
     - Historic Address on National Unity (12 Feb 1949)
     - Address to the Nation on Security and Rehabilitation (12 Oct 1947)
     - "Steel Frame of India" — Foundational Civil Services Address (1947)

   - **Martin Luther King Jr. (5 Speeches):**
     - "I Have a Dream" (1963 March on Washington)
     - "I've Been to the Mountaintop" (1968 Memphis, day before assassination)
     - "Beyond Vietnam: A Time to Break Silence" (Riverside Church 1967)
     - "The Other America" (Stanford 1967)
     - "How Long, Not Long" (Selma to Montgomery 1965)

   - **Winston Churchill (5 Speeches):**
     - "Blood, Toil, Tears and Sweat" (1940)
     - "We Shall Fight on the Beaches" (1940)
     - "Their Finest Hour" (1940)
     - "We Shall Never Surrender" (1940)
     - "Iron Curtain" (Sinews of Peace, 1946)

   - **John F. Kennedy (3 Speeches):**
     - Inaugural Address: "Ask Not What Your Country Can Do For You" (1961)
     - "We Choose to Go to the Moon" (Rice University 1962)
     - "Ich bin ein Berliner" (West Berlin 1963)

   - **Nelson Mandela (5 Speeches):**
     - "I Am Prepared to Die" (Rivonia Trial 1964)
     - Address to Joint Session of US Congress (1990)
     - Presidential Inauguration Address (1994)
     - "Sport Has the Power to Change the World" (Laureus 2000)
     - "Make Poverty History" (Trafalgar Square 2005)

   - **Adolf Hitler (Historical Educational Archive - 4 Speeches):**
     - Sportpalast Total War Speech (1943 with English subtitles)
     - Reichstag Address on Outbreak of War (1939 with English subtitles)
     - 1936 Berlin Olympic Games Address
     - Operation Barbarossa Radio Address (1941)

   - **Barack Obama (3 Speeches):**
     - "Yes We Can" (2008 Chicago Election Night Victory)
     - 2004 DNC Keynote Address ("One America")
     - Farewell Address to the Nation (Chicago 2017)

   - **Swami Vivekananda (3 Speeches):**
     - Chicago Address (1893 World's Parliament of Religions narration)
     - "Sisters and Brothers of America" Opening Speech
     - Paper on Hinduism at World Parliament of Religions

2. **Audio & Media Playback:**
   - Dedicated player activity with interactive **Play**, **Pause**, and scrub controls.
   - Embed WebView with YouTube IFrame Player API (`enablejsapi=1`, zero API keys required, lightweight, cross-version compatible).
   - Display full metadata: title, speaker name, year, and historical significance description.
   - Clean lifecycle management: automatically pause audio when app is minimized or back pressed.

3. **User Interface (Material Design 3):**
   - Categorized by speaker with custom colored avatar circles and country flags.
   - Expandable / collapsible sections per leader.
   - Instant real-time search bar filtering across speech titles, speaker names, years, and topics.
   - Modern indigo/saffron palette with dark theme support.

4. **Technical Architecture:**
   - Java, Min SDK 24 (Android 7.0+), Target SDK 34 (Android 14).
   - Android Gradle Plugin 8.5+, Gradle 8.7 wrapper (`gradlew.bat`).
   - Clean modular architecture: `model/`, `data/`, `adapter/`, `MainActivity`, `PlayerActivity`.
   - Compile command: `./gradlew assembleDebug`.
```
