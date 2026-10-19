# Nuvora

Nuvora is a free/libre Android application designed to translate meteorological data into clear, honest, and easy-to-understand information.

## Current Status (Milestone 0)
Nuvora is currently in **Milestone 0 (Project Foundation)**. At this stage, the repository provides:
- A single-module (`:app`) Android build with Jetpack Compose and Material 3.
- A placeholder initial screen with no meteorological functionality or network calls yet.
- Base internationalization (`en` and `es`) with strict translation lint rules.
- Continuous integration via GitHub Actions and base Fastlane metadata structure.

Weather data integration (via Open-Meteo), plain-language weather translations, and location management are planned for upcoming milestones (see [`docs/ROADMAP.md`](docs/ROADMAP.md)).

## Technical Overview
- **Language**: Kotlin
- **UI**: Jetpack Compose + Material 3
- **Minimum SDK**: Android 8.0 (API 26)
- **Application ID**: `io.github.nubeliax.nuvora`

## Building & Verifying
Using the included Gradle Wrapper (requires JDK 17 and the Android SDK):

```bash
./gradlew testDebugUnitTest lintDebug assembleDebug
```

## Documentation
- [`docs/ROADMAP.md`](docs/ROADMAP.md) — Project milestones and status.
- [`docs/ARCHITECTURE.md`](docs/ARCHITECTURE.md) — Current structure and confirmed technical decisions.
- [`docs/WEATHER_RULES.md`](docs/WEATHER_RULES.md) — Guiding principles for meteorological communication.
- [`PRIVACY.md`](PRIVACY.md) — Privacy commitments.
- [`CONTRIBUTING.md`](CONTRIBUTING.md) — Guidelines for contributors.

## License
This project is licensed under the **GNU General Public License v3.0 or later** (`GPL-3.0-or-later`). See [`LICENSE`](LICENSE) for full details.
