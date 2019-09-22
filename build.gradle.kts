buildscript {
    repositories {
        jcenter { url = uri("https://maven.aliyun.com/repository/jcenter") }
        google()
    }

    dependencies {
        //Android编译插件
        //https://developer.android.com/studio/releases/gradle-plugin
        classpath("com.android.tools.build:gradle:3.5.0")
    }
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}
