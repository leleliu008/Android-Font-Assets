plugins {
    id("com.android.library")
    
    //https://github.com/leleliu008/BintrayUploadGradlePlugin
    //https://plugins.gradle.org/plugin/com.fpliu.bintray
    id("com.fpliu.bintray").version("1.0.7")

    //用于构建aar和maven包
    //https://github.com/dcendents/android-maven-gradle-plugin
    id("com.github.dcendents.android-maven").version("2.0")

    //用于上传maven包到jCenter中
    //https://github.com/bintray/gradle-bintray-plugin
    id("com.jfrog.bintray").version("1.7.3")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        versionCode = 1
        versionName = "1.0.0"
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDir("src/main/libs")
            java.srcDirs("src/main/kotlin")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    lintOptions {
        isAbortOnError = false
    }

    compileOptions {
        //使用JAVA8语法解析
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

// 这里是groupId,必须填写,一般填你唯一的包名
group = "com.fpliu"

//这个是版本号，必须填写
version = android.defaultConfig.versionName ?: "1.0.0"

bintrayUploadExtension {
    developerName = "leleliu008"
    developerEmail = "leleliu008@gamil.com"

    projectSiteUrl = "https://github.com/$developerName/Android-Font-Assets"
    projectGitUrl = "https://github.com/$developerName/Android-Font-Assets"

    bintrayOrganizationName = "fpliu"
    bintrayRepositoryName = "newton"
}
