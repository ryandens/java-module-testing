plugins {
    id("com.gradle.enterprise") version "3.15"
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

rootProject.name = "java-module-testing"

gradleEnterprise {
    val runsOnCI = providers.environmentVariable("CI").getOrElse("false").toBoolean()
    if (runsOnCI) {
        buildScan {
            publishAlways()
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
        }
    }
}
