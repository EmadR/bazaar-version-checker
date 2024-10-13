// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "BazaarVersionChecker",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "BazaarVersionChecker",
            targets: ["BazaarVersionCheckerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "BazaarVersionCheckerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/BazaarVersionCheckerPlugin"),
        .testTarget(
            name: "BazaarVersionCheckerPluginTests",
            dependencies: ["BazaarVersionCheckerPlugin"],
            path: "ios/Tests/BazaarVersionCheckerPluginTests")
    ]
)