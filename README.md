# Broadcasting Assignment

Broadcasting assignment for CSE489: Android Development

## Github Repository

- Repository - [https://github.com/tanviranindo/broadcasting-assignment](https://github.com/tanviranindo/broadcasting-assignment)

- JavaScript - [https://github.com/tanviranindo/broadcasting-assignment/tree/main](https://github.com/tanviranindo/broadcasting-assignment/tree/main)

- Native - [https://github.com/tanviranindo/broadcasting-assignment/tree/native](https://github.com/tanviranindo/broadcasting-assignment/tree/native)

# Stack

- Vue JS
- Capacitor JS
- Quasar

# Instruction

### Build

Install the dependencies

```bash
npm install
```

or

```bash
yarn install
```

### Development

Start the application in the development mode (hot-code reloading, error reporting, etc.)

```bash
quasar dev
```

### Add

Install the @capacitor/android package for android

```bash
yarn add @capacitor/android
```

Install the @capacitor/ios package for iOS

```bash
yarn add @capacitor/ios
```

### Build

Build the app for production

```bash
quasar build
```

Sync the project

```bash
npx cap sync
```

Add the Android platform

```bash
npx cap add android
```

Add the iOS platform

```bash
npx cap add ios
```

### Android Studio

To open the project in Android Studio

```bash
npx cap open android

```

### Xcode

To open the project in Xcode

```bash
npx cap open ios

```

### Run

To run the project on a device or simulator

```bash
npx cap run android

```

or

```bash
npx cap run ios

```

# Support

This application has been tested on both portrait and landscape mode in the following devices.

| Status |    Model    | API |  Display  |
| :----: | :---------: | :-: | :-------: |
|   ✔    |   Pixel 5   | 32  | 2340x1080 |
|   ✔    |  Pixel 4XL  | 31  | 3040x1440 |
|   ✔    |   Pixel 3   | 31  | 2160x1080 |
|   ✔    |  Pixel 2XL  | 30  | 2880x1440 |
|   ✔    |  Pixel XL   | 30  | 2560x1440 |
|   ✔    |   Nexus 6   | 30  | 2560x1440 |
|   ✔    |  Nexus 6P   | 29  | 2560x1440 |
|   ✔    |  Pixel 3a   | 28  | 2220x1080 |
|   ✔    |  Nexus 5X   | 27  | 1920x1080 |
|   ✔    | Pixel 3a XL | 26  | 2160x1080 |
|   ✔    | Pixel 3a XL | 25  | 2160x1080 |
|   ✔    | Pixel 3a XL | 24  | 2160x1080 |
|   ❌   |   Nexus 7   | 22  | 1280x800  |

# Update

As per requirements, the assignment is completed, but additional features that can be added are following

- [ ] Write custom plugin for native android library. For example, WifiManager (Turn on/off)
- [ ] Beautify it
