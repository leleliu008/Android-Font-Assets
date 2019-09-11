buildscript {
    repositories {
        jcenter { url = uri("https://maven.aliyun.com/repository/jcenter") }
    }
    dependencies {
        //对android-maven-gradle-plugin和gradle-bintray-plugin两个插件的包装、简化插件
        //https://github.com/leleliu008/BintrayUploadAndroidGradlePlugin
        classpath("com.fpliu:BintrayUploadGradlePlugin:1.0.7")
    }
}

apply {
    plugin("com.fpliu.bintray")
}

plugins {
    id("com.android.library")

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
        //minSdkVersion(18)
        //targetSdkVersion(28)
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

dependencies {
}

// 这里是groupId,必须填写,一般填你唯一的包名
group = "com.fpliu"

//这个是版本号，必须填写
version = android.defaultConfig.versionName ?: "1.0.0"

(project.extensions.getByName("bintrayUploadExtension") as com.fpliu.gradle.BintrayUploadExtension).apply {
    developerName = "leleliu008"
    developerEmail = "leleliu008@gamil.com"

    projectSiteUrl = "https://github.com/$developerName/Android-Font-Assets"
    projectGitUrl = "https://github.com/$developerName/Android-Font-Assets"

    bintrayOrganizationName = "fpliu"
    bintrayRepositoryName = "newton"
}
