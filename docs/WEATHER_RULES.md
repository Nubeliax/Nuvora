# Weather Rules & Principles — Nuvora

This document establishes the **general principles** for how Nuvora will interpret and communicate meteorological data. Concrete thresholds, formulas, and specific rule implementations are not defined in Milestone 0 and will be specified in future milestones.

## 1. Observation, Estimation, and Forecast
- Distinguish three distinct concepts—**current observation**, **estimation** (such as model analysis), and **forecast**—and never conflate or merge them.
- The user interface must clearly distinguish between what is happening now and what is expected later, always indicating the reference time of the data.
- Never confuse current conditions with the values forecast for the rest of the day, and always respect the exact time period to which each data point refers (instant, hour, or day).

## 2. Never Invent Data
- Nuvora only translates data actually provided by the meteorological source (Open-Meteo).
- If a metric or variable is missing, unavailable, or fails to load, Nuvora must explicitly report its absence rather than interpolating silently, assuming default values (such as `0`), or fabricating certainty.
- Never claim exact hours of rain without backing in the data.

## 3. Probability vs. Amount
- Precipitation probability (how likely it is to rain or snow) and precipitation amount/intensity (how much water is expected to fall) are distinct physical and statistical concepts.
- A high probability of light drizzle must not be confused with a heavy storm, and a low probability of a severe downpour must not be dismissed as "no rain possible." Both dimensions must be communicated clearly without conflating them.

## 4. Communicating Uncertainty and Avoiding Alarmism
- Weather predictability decreases as the forecast horizon increases and varies depending on atmospheric stability.
- Plain-language summaries should reflect appropriate confidence levels: near-term forecasts can use more direct phrasing, while multi-day outlooks should use language that acknowledges variability and potential change.
- Avoid alarmism: never label any condition as "dangerous" without sufficient criteria and backing data.

## 5. Units and Time Zones
- All meteorological calculations and internal representations must use explicit, unambiguous physical units, converting to the user's preferred display units (`°C`/`°F`, `km/h`/`mph`/`m/s`, and `mm`) only for presentation.
- Timestamps must always respect the **local time zone of the queried location** (as well as clearly handling the device time when relevant), avoiding ambiguity around daylight saving transitions or UTC offsets.
