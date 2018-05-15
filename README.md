# Appium Sample Tests for AWS Device Farm Sample App
This is a collection of example Appium TestNG tests written for the AWS Device Farm [Android](https://github.com/awslabs/aws-device-farm-sample-app-for-android) sample app. Please use these tests as a reference for your own AWS Device Farm Appium TestNG tests.

**This test suite uses the [Appium page model](http://appium.io/slate/en/tutorial/android?java#page-object-pattern) in order to separate the tests from the logic.**

# Android
## Getting Started
1. Follow the **[official Appium getting started guide](http://appium.io/slate/en/tutorial/android.html?java#getting-started-with-appium)** and install the Appium server and dependencies. 

	**AWS Device Farm supports Appium version 1.7.2. Using a different version locally may cause unexpected results when running Appium tests on AWS Device Farm.**
2. In order to use 1.7.2, download Appium through NPM with this command: 
	```
	npm install -g appium@1.7.2
	```
3. Verify that you have Appium installed with this command: 
	```
	appium -v
	```
   You should get "1.7.2" as the output

## Creating a new Java Appium Test Project Using Maven
1. Create a new Maven project using a Java IDE. **The example in this tutorial is for [IntelliJ IDEA Community Edition](http://www.jetbrains.com/idea/download/)**.

2. Set up your POM file using the official AWS Device Farm documentation for [TestNG](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-appium-java-testng.html)
	- You will need the following dependencies in your POM file
		
        ```
	    <dependencies>
    	    <dependency>
        	    <groupId>org.testng</groupId>
            	<artifactId>testng</artifactId>
	            <version>6.11</version>
    	        <scope>test</scope>
        	</dependency>
	        <dependency>
    	        <groupId>io.appium</groupId>
        	    <artifactId>java-client</artifactId>
            	<version>4.1.2</version>
	        </dependency>
    	</dependencies>
        ```
	
### Running Your Tests Locally
First, make sure that you have followed all the steps in the [Appium getting started guide](http://appium.io/slate/en/tutorial/android.html?java#getting-started-with-appium). 

Use the script [start-appium-android.sh](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/start-appium-android.sh) to run the Appium server locally. Once the server has started, run the TestNG tests within your IDE.

For example, if your package name is **com.appium.example**, your main activity name is **.Activities.MainActivity**, and the absolute filepath to your APK is **~/Desktop/appium/app.apk**, you would run the following command.

```
appium --pre-launch --app-pkg com.appium.example --app-activity .Activities.MainActivity --platform-name Android --app ~/Desktop/appium/app.apk
```

### Running Your Tests on AWS Device Farm
#### Step 1: Verify the Project Set-up
First Read the [Device Farm documentation](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-calabash.html). Ensure that all the steps are completed and that your project and POM file are set up correctly. 

#### Step 2: Go into your Maven Appium Directory
Go into your Appium Maven project directory in the terminal or command prompt.

#### Step 3: Package the Test Content
Run the following Maven command to package the test content.
```
mvn clean package -DskipTests=true
```
#### Step 4: Locate the zip-with-dependencies.zip file
Once the Maven command above is finished it will produce a "zip-with-dependencies.zip" file in your target folder. You will upload this file when [creating a run](http://docs.aws.amazon.com/devicefarm/latest/developerguide/how-to-create-test-run.html) on AWS Device Farm.

<img src="https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/readme_images/appium-tests.gif" width="400">

## Examples For Android 
### Examples for Testing Specific Scenarios
|Component|Android Implementation|Tests|
|----------|----------------------|-------|
|Alerts: [Toasts](http://developer.android.com/guide/topics/ui/notifiers/toasts.html) and [Dialogs](http://developer.android.com/guide/topics/ui/dialogs.html)   | [source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/NotificationsFragment.java)              |[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/AlertPageTest.java)|
|Fixtures|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/FixturesFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/FixturesTest.java)|
|Static Page: [TextView](http://developer.android.com/reference/android/widget/TextView.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/fragment_homepage.xml)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/HomePageTest.java)|
|Login Page|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/LoginFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/LoginTest.java)|
|Nested Views: [Back and Up Navigation](http://developer.android.com/design/patterns/navigation.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/NestedFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/NestedViewsTest.java)|
|[Web Views](http://developer.android.com/reference/android/webkit/WebView.html)|<ul><li><a href ="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/LocalWebView.java">Hybrid Web Views</a></li><li><a href="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/WebViewFragment.java">Web View</a></li></ul>|<ul><li>Hybrid Web Views (Not implemented)</li><li><a href="https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/WebViewTest.java">Web View</a></li></ul>|
| An Expected Crash|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/crashFragment.java)|Not implemented|

### Strategies for Native Features
|Feature|Android Implementation|Tests|
|--------|----------------------|-------|
|[Camera](http://developer.android.com/guide/topics/media/camera.html)  |[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Native/Native_CameraFragment.java) |[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/CameraTest.java)|
|[Image Collection Grid](http://developer.android.com/guide/topics/ui/layout/gridview.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Native/Native_ImageGalleryFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/ImageGalleryTest.java)|
|[Scroll View](http://developer.android.com/reference/android/widget/ScrollView.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/native_content_scrolling.xml)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/ScrollViewTest.java)
|Out of View Content|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/native_out_of_view_scrolling.xml)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/OutOfViewTest.java)|
|[Video](http://developer.android.com/reference/android/media/MediaPlayer.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Native/Native_MediaPlayer.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/MediaPlayerTest.java)|

### Examples for Testing Inputs
|Component|Android Implementation|Tests|
|--------------|---------|----------|
|[Checkbox](http://developer.android.com/reference/android/widget/CheckBox.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_CheckBoxFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/CheckboxTest.java)|
|[DatePicker](http://developer.android.com/reference/android/widget/DatePicker.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_DatePickerFragment.java)|Not implemented (not directly supported by Appium)|
|[EditText](http://developer.android.com/reference/android/widget/EditText.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/input_textfield.xml)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/EditText.java)|
|[Gestures Input](http://developer.android.com/training/gestures/index.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_GestureFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/GesturesTest.java)|
|[Pull to Refresh](https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_RefreshButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/PullToRefreshTest.java)|
|[Radio Buttons](http://developer.android.com/guide/topics/ui/controls/radiobutton.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_RadioButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/RadioButtonTest.java)|
|[TimePicker](http://developer.android.com/reference/android/widget/TimePicker.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_TimePickerFragment.java)|Not implemented (not directly supported by Appium)|
|[Toggle Button](http://developer.android.com/guide/topics/ui/controls/togglebutton.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_Toggle_ButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/ToggleButtonTest.java)|
|[Spinner Input](http://developer.android.com/guide/topics/ui/controls/spinner.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_SpinnerFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/SpinnerTest.java)|
|[Buttons](http://developer.android.com/reference/android/widget/Button.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_SubmitButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Pages/AlertPage.java)|

### Examples for Automated Navigation
|Component|Android Implementation|Tests|
|--------------|---------|----------|
|[Navigation Drawer](https://developer.android.com/training/implementing-navigation/nav-drawer.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/NavigationDrawerFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Pages/NavigationPage.java)|
|[ViewPager](http://developer.android.com/reference/android/support/v4/view/ViewPager.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/TabFragmentContainer.java)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Pages/TabViewPage.java)|

## Tips and Tricks
#### Driver Configuration
Remember to set up your Appium driver correctly. AWS Device Farm takes care of the configuration for you, and you don't need to set any of the DesiredCapabilities when creating the driver. Refer to **[this example](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/AbstractBaseTests/TestBase.java#L75)**.
