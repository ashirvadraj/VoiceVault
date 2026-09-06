# VoiceVault 🎙️ — Greatest Speeches Android App

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24)
[![Material Design 3](https://img.shields.io/badge/Design-Material%203-blue.svg)](https://m3.material.io)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**VoiceVault** is an Android application designed to let users explore, search, and listen to iconic historical speeches delivered by world leaders, freedom fighters, and visionary figures.

---

## ✨ Features

- 🎧 **80+ Curated Historical Speeches** across 15 world-renowned figures.
- ▶️ **Dedicated Audio & Video Player**: Full Play, Pause, and Seeking controls via an embedded YouTube IFrame engine (no API key required).
- 🔍 **Real-Time Instant Search**: Dynamic filtering across speech titles, speaker names, years, and historical descriptions.
- 📂 **Expandable Speaker Catalogs**: Clean accordion list view organized by leader with national badges.
- 🎨 **Material Design 3**: Modern, responsive UI with full Dark Theme support.

---

## 🏛️ Featured Speakers & Highlights

| Speaker | Speeches | Highlights |
|---|:---:|---|
| **Atal Bihari Vajpayee** | **16** | 1996 No-Confidence Motion ("Sarkarein Aayengi Jayengi"), 1977 UN Hindi Address, Pokhran Nuclear Test, Kargil War, Poem Recitations ("Geet Naya Gaata Hoon", "Kadam Milakar Chalna Hoga") |
| **Dr. A. P. J. Abdul Kalam** | **12** | Three Visions for India, Leadership & Failure (Prof. Satish Dhawan story), European Parliament, "Dream, Dream, Dream", IIT Innovation address, Last Speech at IIM Shillong |
| **Pandit Jawaharlal Nehru** | **8** | "Tryst with Destiny" (Midnight independence address & Prasar Bharati audio), "The Light Has Gone Out of Our Lives" (Gandhi eulogy), Red Fort Independence Day addresses |
| **Sachin Tendulkar** | **5** | Immortal 20-minute Farewell Speech at Wankhede Stadium (2013), "Right to Play" sports vision, ICC Hall of Fame induction, 2011 World Cup victory address |
| **Lal Bahadur Shastri** | **5** | "Jai Jawan, Jai Kisan" (1965), 1965 War radio broadcasts, Tashkent declaration |
| **Dr. Sarvepalli Radhakrishnan** | **5** | On Education & Teachers (Teachers' Day origin), Philosophy of Life, Bhagavad Gita discourse, UNESCO address |
| **Netaji Subhas Chandra Bose** | **3** | "Give me blood, and I will give you freedom", "Dilli Chalo", Azad Hind Radio address |
| **Sardar Vallabhbhai Patel** | **3** | National Unity address (1949), "Steel Frame of India" civil service address |
| **Martin Luther King Jr.** | **5** | "I Have a Dream", "I've Been to the Mountaintop", "Beyond Vietnam", "The Other America" |
| **Winston Churchill** | **5** | "Blood, Toil, Tears and Sweat", "We Shall Fight on the Beaches", "Their Finest Hour", "Iron Curtain" |
| **John F. Kennedy** | **3** | Inaugural Address ("Ask not what your country can do for you"), "We Choose to Go to the Moon", "Ich bin ein Berliner" |
| **Nelson Mandela** | **5** | "I Am Prepared to Die" (Rivonia Trial), US Congress, Inauguration, "Sport has the power to change the world" |
| **Adolf Hitler** | **4** | Historical archival footage: Sportpalast speech (subtitled), 1939 Reichstag, 1936 Berlin Olympics |
| **Barack Obama** | **3** | "Yes We Can" (2008 victory), 2004 DNC address, Farewell address |
| **Swami Vivekananda** | **3** | Chicago World Parliament of Religions (1893), "Sisters and Brothers of America" |

---

## 🚀 Building from Source

### Prerequisites
- JDK 17
- Android SDK (API 34+)

### Build Debug APK
```bash
# Clone the repository
git clone https://github.com/<username>/VoiceVault.git
cd VoiceVault

# Build debug APK using Gradle wrapper
./gradlew assembleDebug       # Linux / macOS
.\gradlew.bat assembleDebug   # Windows
```

The output APK will be located at:
`app/build/outputs/apk/debug/app-debug.apk`

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
