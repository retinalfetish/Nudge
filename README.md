# Nudge
A simple Composable replacement for traditional [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts) messages in Android. It uses a reversed `LazyColumn` placed at the bottom and supports four different customizable notification types.

## Screenshots
<img src="/art/screenshot-default.gif" height=600 alt="Screenshot"> <img src="/art/screenshot-clickable.gif" height=600 alt="Screenshot">

## Getting Started
The latest build is available via [JitPack](https://jitpack.io/#com.unary/nudge). Simply add the repository to your `settings.gradle.kts` and the library dependency to your app `build.gradle.kts`.
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // ...
        maven { url = uri("https://jitpack.io") }
    }
}
```
```
dependencies {
    // ...
    implementation("com.unary:nudge:1.0.0")
}
```
## Usage
Wrap the section of your UI where notifications should appear with `NudgeHost`. This is typically near the root or around the navigation component, but it can also be applied on a per-screen basis.
```
AppTheme {
    NudgeHost {
        Scaffold {
            // ...
        }
    }
}
```
Then you can use `Nudge` in place of `Toast`. Along with the message you can specify an optional `durationMillis`. There are four different notification types: `info`, `success`, `warning`, `error`.
```
Button(onClick = { Nudge.info(message = "Hello, World!") }) {
    Text(text = "Info")
}
```
## Customization
Each notification type uses colors from the current Material theme by default. The container and content colors of each type can be customized, as well as the shape used for all notifications.
```
NudgeHost(
    colors = NudgeDefaults.nudgeColors(
        errorContainerColor = Color.Orange,
        errorContentColor = Color.White
    ),
    shape = MaterialTheme.shapes.extraLarge
    ) {
        // ...
}
```
## License
This project is licensed under the Apache License 2.0. You may use, distribute, and modify this software under the terms of the license.
