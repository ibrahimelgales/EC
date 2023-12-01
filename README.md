### EC APP


---------

## Table of contents

- [Features](#features)
- [Installation](#Installation)
- [Implementation Details](#implementation-details)
- [API](#api)
- [App Architecture](#app-architecture)
- [Preview](#preview)
- [License](#license)

---------

## Features

* APP detects whether a device is rooted or not and prevents the app from being used on that device.
* If your device's USB debugging is enabled, the app will detect it and prevent you from using it.
* The app uses Firebase DB to store values that are then saved on Encrepted SharedPreferences.
* To reduce the risks of reverse engineering, APP enabled Code Obfuscation.
* The landing page show competitions list with basic info (Competition name, Area name and Competition emblem).
* User can a specific competition to show the teams on it with more information about team.
* APP use a custom error handling to catch errors happen.
* Applying a unit test on All usecases.
* Using kotlin compose with a Modern Architecture
  1. MVVM for presentation layer.
  2. kotlin DSL for gradle.
  3. Modularized architecture.
  4. Domain layer for business logic.
  5. Data layer.

 





--------

## Installation

Clone this repository and import into **Android Studio**
```bash
git clone git@github.com:ibrahimelgales/EC.git
```

### `Demo`

Download App Apk : [EC APP](https://github.com/ibrahimelgales/Files/blob/main/EC_DEMO.apk)

------

## Implementation Details

### `Layout`
- The app layout interface is implemented by kotlin compose.


### `Permission`
-The App requires runtime permissions of
* **INTERNET**
* **ACCESS_NETWORK_STATE**


### `Data`
- The app uses a Rest Api to fetch data from a football data remote Api.

### `Error Handling`
- The performed requests handle successful results, failure results


### `Technologies used`

- Kotlin.
- Coroutines and Flow for async operations.
- Koin as service locator.
- EncryptedSharedPreferences.
- Firebase realtime database.
- ViewModel that stores, exposes and manages UI state.
- Retrofit for networking.
- Coil for image loading.
- Coroutines + Flow.
- Kotlin Compose.
- Mockito for unit test.

<br/>

---------

## Api

- [football-data v4](https://www.football-data.org/)

---------

## App Architecture
<br/>


<img src="https://github.com/ibrahimelgales/Files/blob/main/app_arch.png?raw=true" alt="App Architecture" width="4000"/>


<br/>
<br/>
<br/>


### Application Clean Architecture
<br/>

<img src="https://github.com/ibrahimelgales/Files/blob/main/clean_arch.png?raw=true" alt="Clean Architecture" height="280"/>

<br/>


### Why Clean Architecture ?

- Clean, Testable, Maintainable and extendable Codebase
- Apply high cohesion and low coupling
- Apply Separation of concerns principle
- Apply Single source of truth principle
- Fine-grained dependency control.
- Improve re-usability across other apps.
- Improves the ownership & the quality of the codebase.

<br/>

---------


## Preview

|                                                1                                    |                                            2                                        |                                                3                                    |                                            4                                        |                                            5                                       |
|:-----------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------:| :----------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------:|
| ![screenshot](https://github.com/ibrahimelgales/Files/blob/main/01_EC.png?raw=true) | ![screenshot](https://github.com/ibrahimelgales/Files/blob/main/02_EC.png?raw=true) | ![screenshot](https://github.com/ibrahimelgales/Files/blob/main/03_EC.png?raw=true) | ![screenshot](https://github.com/ibrahimelgales/Files/blob/main/04_EC.png?raw=true) |![screenshot](https://github.com/ibrahimelgales/Files/blob/main/05_EC.png?raw=true) |


| ![video](https://github.com/ibrahimelgales/Files/blob/main/ec.gif?raw=true) |

---------


### License

<details>
    <summary>
        Click to reveal License
    </summary>

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

</details>
