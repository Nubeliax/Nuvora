# Roadmap — Nuvora

This document tracks the planned milestones for Nuvora. Work progresses sequentially one milestone at a time, and advancing from one milestone to the next requires explicit approval from the maintainer.

| Milestone | Description | Status |
| :--- | :--- | :--- |
| **Milestone 0** | Preparation. Project structure, Gradle and wrapper, license, `AGENTS.md`, documentation, i18n base, base Fastlane metadata, initial screen, test setup with a trivial passing test, and CI workflow. | **In progress** |
| **Milestone 1** | Compilable and reproducible skeleton. `./gradlew testDebugUnitTest lintDebug assembleDebug` passes in CI from a clean clone; configuration problems are fixed before adding features. | Pending |
| **Milestone 2** | Open-Meteo model and API. Isolated integration with error and missing-data handling; JSON fixtures and `MockWebServer` tests before it is considered done. | Pending |
| **Milestone 3** | Main screen. Current conditions and natural-language explanations; rules with unit tests first. | Pending |
| **Milestone 4** | Daily forecast. Upcoming days and rules for communicating them; rules with unit tests first. | Pending |
| **Milestone 5** | Locations. Manual city search and selection first; then current location with minimal permissions. | Pending |
| **Milestone 6** | Dynamic visual design. Backgrounds and variations by weather and time of day, with attention to accessibility, performance and contrast. | Pending |
| **Milestone 7** | Persistence and robustness. Room only if justified; caching and behavior on poor connections. | Pending |
| **Milestone 8** | Quality and release. Accessibility, battery use, privacy, licenses, tests, documentation and current F-Droid requirements. | Pending |

## Known Pending Items for Later Milestones
- **Per-app language support on Android < 13**: To be implemented when an in-app language selector exists; milestone not yet assigned (to be decided with the maintainer).
- **About screen (license, source code, Open-Meteo attribution, third-party notices)**: Required by the project; milestone to be decided with the maintainer, before the first release.
- **Fastlane graphics**: Real icon graphics, feature graphics, and screenshots in `fastlane/metadata/android/*/images/` will be created in Milestone 8.
