# 📱 FinalAssignment – Android App (Victoria University Sydney Campus)

This Android app was developed for the Mobile Application Development unit at Victoria University. It showcases clean code practices, dynamic API integration based on student credentials, and dependency injection using Hilt.

---

## ✅ Features

- 🔐 **Login Page** – Authenticates using first name + student ID to retrieve a keypass.
- 📊 **Dashboard Page** – Uses keypass to fetch and display a personalized entity list.
- 📄 **Detail Page** – Displays detailed entity information (customized by keypass).
- 🚪 **Logout Buttons** – Available on both Dashboard and Detail screens.
- 🌙 **Dark Themed UI** – With white text, black backgrounds, and blue accent buttons.

---

## 📂 Project Structure
FinalAssignment_1/
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/com/example/finalassignment_1/
│   │   │   │   ├── AuthRequest.kt
│   │   │   │   ├── AuthResponse.kt
│   │   │   │   ├── AuthService.kt
│   │   │   │   ├── DashboardActivity.kt
│   │   │   │   ├── DashboardAdapter.kt
│   │   │   │   ├── DashboardItem.kt
│   │   │   │   ├── DashboardResponse.kt
│   │   │   │   ├── DashboardService.kt
│   │   │   │   ├── DashboardViewModel.kt
│   │   │   │   ├── DetailsActivity.kt
│   │   │   │   ├── LoginActivity.kt
│   │   │   │   ├── LoginViewModel.kt
│   │   │   │   ├── MyApplication.kt
│   │   │   │   └── RetrofitModule.kt
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_dashboard.xml
│   │   │   │   ├── activity_details.xml
│   │   │   │   └── item_dashboard.xml
│   │   │   ├── menu/
│   │   │   │   ├── menu_dashboard.xml
│   │   │   │   └── menu_details.xml
│   │   │   └── values/
│   │   │       └── themes.xml
│   ├── src/test/java/com/example/finalassignment_1/
│   │   ├── ExampleUnitTest.kt
│   │   ├── LoginRequestTest.kt
│   │   └── RetrofitModuleTest.kt
├── build.gradle.kts
├── settings.gradle.kts
└── README.md

---


## ⚙️ Dependencies

These dependencies must be included in your `build.gradle.kts`:

```Kotlin
// Hilt
implementation("com.google.dagger:hilt-android:2.48")
kapt("com.google.dagger:hilt-android-compiler:2.48")

// Retrofit & Moshi
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

// Javapoet (required for Hilt)
implementation("com.squareup:javapoet:1.13.0")

// AndroidX
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("androidx.activity:activity-ktx:1.7.2")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
```
---

ViewModel Unit Testing
app/src/test/java/com/example/finalassignment_1/


👨‍🎓 Author
Kanghyeok LEE s8070108
Victoria University Sydney Campus
Bachelor of Information Technology


