# Picture Puzzle Cube - Android Studio Project

## Requirements
- Android Studio (latest stable version recommended)
- Basic knowledge of Java/Kotlin development
- Android device or emulator for testing

## How to Open the Project
1. Download and extract the ZIP file.
2. Open **Android Studio**.
3. Click **File → Open** and select the project folder.
4. Let Gradle finish syncing automatically.

## How to Customize
- **Change game images:**
  - Replace puzzle images inside the `/res/drawable` folder.
  - Keep the same file names or update references in the code.
- **Change app name and icon:**
  - Update `app_name` in `res/values/strings.xml`.
  - Replace the launcher icon in `/mipmap` folders.
- **Change package name (optional):**
  - In Android Studio, right-click your package → Refactor → Rename.
  - Update the `applicationId` in `app/build.gradle`.

## Add AdMob (if using ads)
1. Open `AndroidManifest.xml` and insert your AdMob App ID.
2. Open the code file where ads are loaded and replace the test ad unit IDs with your own.
3. Test ads before publishing to Google Play to ensure proper integration.

## Build & Run
- Connect your Android device or start an emulator.
- Click **Run ▶** in Android Studio.
- Your app should launch automatically.

## Multi-Platform Compatibility (Android, Tablets, Fire Tablets, Fire TV, Automotive)

This application has been enhanced to support a wider range of Android-based devices, including tablets, Fire Tablets, Fire TV, and Android Automotive OS.

**Key Compatibility Features:**
- **Adaptive UI:** The user interface adjusts dynamically to different screen sizes and orientations, providing an optimized experience on both small phone screens and larger tablet/TV displays.
- **Gamepad/D-pad Support:** For devices without touchscreens (e.g., Fire TV, Android Automotive), the application now fully supports navigation and interaction using D-pad and gamepad inputs.
    - **D-pad UP/DOWN/LEFT/RIGHT:** Corresponds to U/D/L/R cube moves.
    - **A/X Button:** Shuffle the cube.
    - **B/Y Button:** Reset the cube.
    - **L1/R1 Button:** Undo last move.
    - **Start/Select Button:** Open instructions.
    - **L2 Button:** Toggle Prime moves.
    - **R2 Button:** Show hint.
    - **Thumb L/R Buttons:** Set difficulty to Medium (example, can be extended for cycling difficulties).
- **Manifest Declarations:** The `AndroidManifest.xml` includes necessary declarations to ensure the app is discoverable and functions correctly on Android TV (Leanback launcher) and Android Automotive OS.

## Build & Run
- Connect your Android device or start an emulator.
- Click **Run ▶** in Android Studio.
- Your app should launch automatically.

**To test on specific platforms:**
- **Android Phones/Tablets:** Install the generated APK (`app/build/outputs/apk/debug/app-debug.apk`) directly or run from Android Studio.
- **Fire TV/Android TV:** Install the APK via `adb install path/to/app-debug.apk` or use Android Studio's "Run" option with a connected TV device/emulator.
- **Android Automotive OS:** Use an Automotive OS emulator in Android Studio and install the APK.

## Support
- This is a self-contained project designed for developers.
- Ensure you meet all requirements above before starting customization.
