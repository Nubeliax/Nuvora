# Contributing to Nuvora

Thank you for your interest in contributing to Nuvora.

## Principles
- **Free Software**: All code must be compatible with `GPL-3.0-or-later`. Include `// SPDX-License-Identifier: GPL-3.0-or-later` at the top of every Kotlin file. No proprietary libraries, Play Services, or binary blobs.
- **Privacy First**: Never add analytics, tracking, or unnecessary permissions.
- **Scope Discipline**: Development follows the milestones defined in [`docs/ROADMAP.md`](docs/ROADMAP.md). Do not bundle unrelated features or jump ahead of the current milestone without prior discussion.
- **Internationalization**: Every user-visible string must be defined in both `app/src/main/res/values/strings.xml` (English) and `app/src/main/res/values-es/strings.xml` (Spanish). Hardcoded UI strings in Kotlin are not allowed.
- **Testing**: Include deterministic unit tests for new logic. Never delete, `@Ignore`, or weaken existing tests to make a build pass.

## Verification Before Submitting
Ensure the standard verification suite passes:

```bash
./gradlew testDebugUnitTest lintDebug assembleDebug
```
