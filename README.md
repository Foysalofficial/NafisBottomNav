# Nafis Bottom Navigation Updated
A simple & curved & material bottom navigation for Android written in **Kotlin** with ♥ .

![](https://github.com/shetmobile/MeowBottomNavigation/raw/master/resources/Preview.gif)

## Download

Update your `build.gradle` (project path) like below :

```groovy
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

Update your `build.gradle` (module path) like below :

```groovy
dependencies {
  implementation 'com.github.Foysalofficial:NafisBottomNav:5.0'
}
```

```groovy
dependencies {
  implementation ("com.github.Foysalofficial:NafisBottomNav:5.0")
}
```

Use androidx by adding this lines to `gradle.properties`. If you want more info, just google **AndroidX**.

```properties
android.useAndroidX=true
android.enableJetifier=true
```

If you want to add this library to a JAVA Project, you must add kotlin library to `build.gradle`.

```groovy
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.61"
}
```

```android
android {
    namespace "com.demo.paka"
    compileSdkVersion 34

    defaultConfig {
        applicationId "com.demo.paka"
        minSdkVersion 21
        //noinspection EditedTargetSdkVersion
        targetSdkVersion 34
        versionCode 3
        versionName "1.1"
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding true
    }

}

```

## 😍 Donate & Support

We are developing this framework in open source community without financial planning but the maintenance & preparing updates at periodic times is Time-consuming.
If you like this project and you want to give us peace of mind, you can support us by clicking this button :

<p>
<a href="https://foysalofficial.com">
<img width="20%" src="https://raw.githubusercontent.com/oneHamidreza/Meow-Framework-MVVM/master/Resources/img_support.png"/>
</a>
</p>

## Usage

Add Meow Bottom Navigation in you layout xml file.

```xml
<com.nafis.bottomnavigation.NafisBottomNavigation
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

Add menu items in code.

```kotlin
val bottomNavigation = findView(R.id.bottomNavigation)
bottomNavigation.add(NafisBottomNavigation.Model(1, R.drawable.ic_home))
bottomNavigation.add(NafisBottomNavigation.Model(2, R.drawable.ic_explore))
bottomNavigation.add(NafisBottomNavigation.Model(3, R.drawable.ic_message))
```

Add vectorDrawables.useSupportLibrary = true to your build.gradle inside `defaultConfig{ ... }` to use vector drawable icons.

## Customization

```xml
<com.nafis.bottomnavigation.NafisBottomNavigation
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:mbn_circleColor="#ffffff"
    app:mbn_backgroundBottomColor="#ffffff"
    app:mbn_countBackgroundColor="#ff6f00"
    app:mbn_countTextColor="#ffffff"
    app:mbn_countTypeface="fonts/SourceSansPro-Regular.ttf"
    app:mbn_defaultIconColor="#90a4ae"
    app:mbn_rippleColor="#2f424242"
    app:mbn_selectedIconColor="#3c415e"
    app:mbn_shadowColor="#1f212121"
    app:mbn_hasAnimation="true"    
/>
```

- You can change this properties in **Kotlin/Java** Realtime⌚. 

## Listeners

Use `setOnShowListener()` function to access when a cell has been shown.

```kotlin
bottomNavigation.setOnShowListener {
    // YOUR CODES
}
```

Use `setOnClickMenuListener()` function to access when a cell has been clicked.

```kotlin     
bottomNavigation.setOnClickMenuListener {
    // YOUR CODES
}
```

If you are Java Developer, use this examples :

```java
bottomNavigation.setOnClickMenuListener(new Function1<NafisBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(NafisBottomNavigation.Model model) {
                // YOUR CODES
                return null;
            }
        });

bottomNavigation.setOnShowListener(new Function1<NafisBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(NafisBottomNavigation.Model model) {
                // YOUR CODES
                return null;
            }
        });
```

## Counter Badge

Set counter badge on a specific cell by `setCount(Int,String)`.

```kotlin
bottomNavigation.setCount(CELL_ID, YOUR_STRING)
```

Clear counter badge on a specific cell by `clearCount(Int)`.

```kotlin
bottomNavigation.clearCount(CELL_ID)
```

Clear all counter badges on a specific cell by `clearCount(Int)`.

```kotlin
bottomNavigation.clearAllCounts(TAB_ID)
```

```java Full example

public class MainActivity extends AppCompatActivity {

    private static final int ID_HOME = 1;
    private static final int ID_EXPLORE = 2;
    private static final int ID_MESSAGE = 3;
    private static final int ID_NOTIFICATION = 4;
    private static final int ID_ACCOUNT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.enableEdgeToEdge();
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
            new OnApplyWindowInsetsListener() {
                @Override
                public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                }
            });

        // Find views by ID
        TextView tvSelected = findViewById(R.id.tv_selected);
        NafisBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        Button btShow = findViewById(R.id.btShow);
        EditText etPageId = findViewById(R.id.etPageId);

        // Set custom typeface for tvSelected
        tvSelected.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf"));

        // Set up bottom navigation
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_EXPLORE, R.drawable.ic_explore));
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message));
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notification));
        bottomNavigation.add(new NafisBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account));

        bottomNavigation.setCount(ID_NOTIFICATION, "115");

        bottomNavigation.setOnShowListener(new Function1<NafisBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(NafisBottomNavigation.Model model) {
                String name = "";
                if (model.getId() == ID_HOME) {
                    name = "HOME";
                } else if (model.getId() == ID_EXPLORE) {
                    name = "EXPLORE";
                } else if (model.getId() == ID_MESSAGE) {
                    name = "MESSAGE";
                } else if (model.getId() == ID_NOTIFICATION) {
                    name = "NOTIFICATION";
                } else if (model.getId() == ID_ACCOUNT) {
                    name = "ACCOUNT";
                }

                return null;
            }
        });

        bottomNavigation.setOnClickMenuListener(new Function1<NafisBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(NafisBottomNavigation.Model model) {
                String name = "";

                if (model.getId() == ID_HOME) {
                    name = "HOME";
                } else if (model.getId() == ID_EXPLORE) {
                    name = "EXPLORE";
                } else if (model.getId() == ID_MESSAGE) {
                    name = "MESSAGE";
                } else if (model.getId() == ID_NOTIFICATION) {
                    name = "NOTIFICATION";
                } else if (model.getId() == ID_ACCOUNT) {
                    name = "ACCOUNT";
                }
            }
        });

        bottomNavigation.setOnReselectListener(new Function1<NafisBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(NafisBottomNavigation.Model model) {
                Toast.makeText(MainActivity.this, "Item " + model.getId() + " is reselected.", Toast.LENGTH_LONG).show();
                return null;
            }
        });

        bottomNavigation.show(ID_HOME);

        // Button click to show page by ID
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id;
                try {
                    id = Integer.parseInt(etPageId.getText().toString());
                } catch (Exception e) {
                    id = ID_HOME;
                }
                if (id >= ID_HOME && id <= ID_ACCOUNT) {
                    bottomNavigation.show(id);
                }
            }
        });
    }

    private void enableEdgeToEdge() {
        // Implementation for enabling edge-to-edge display, if applicable
    }
}
```



## Set Default CELL

Use this function :

```kotlin
bottomNavigation.show(CELL_ID)
```
