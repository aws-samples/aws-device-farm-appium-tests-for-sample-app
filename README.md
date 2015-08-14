# Appium Sample Tests for Device Farm Sample App

This is a collection of example Appium TestNG test suites written for the Device Farm [Android]() sample app (iOS is in development). Please use these tests as a reference for your own Device Farm Appium TestNG tests.


# Android

## Getting Started
Follow the **[official Appium getting started guide](http://appium.io/slate/en/tutorial/android.html?java#getting-started-with-appium)** and install the Appium server and dependencies. 

AWS Device Farm uses Appium version 1.4.1. In order for your tests to have maximum compatibility with AWS Device Farm you should download and use version 1.4.1 locally. 

In order to use 1.4.1, download Appium through NPM through this command: 

```
npm install -g appium@1.4.1
```

to verify run this command: 
```
appium -v
```

you should recieve "1.4.1" as the output

## Creating a new Java Appium Test Project Using Maven

1. Create a new maven project using a Java IDE: **the example in the tutorial is for [IntelliJ IDEA Community Edition](http://www.jetbrains.com/idea/download/)**

2. Set up your POM file using the official AWS Device Farm documentation for:
	- [TestNG](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-appium-java-testng.html)
		- You will need the following dependencies in your POM file
		
		```
	    <dependencies>
    	    <dependency>
        	    <groupId>org.testng</groupId>
            	<artifactId>testng</artifactId>
	            <version>6.8.8</version>
    	        <scope>test</scope>
        	</dependency>
	        <dependency>
    	        <groupId>io.appium</groupId>
        	    <artifactId>java-client</artifactId>
            	<version>3.1.0</version>
	        </dependency>
    	</dependencies>
        ```
	
	- [JUnit](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-appium-java-junit.html)
		- You will need the following dependencies in your pom file
		
        ```
      	<dependencies>
      		<dependency>
        		<groupId>junit</groupId>
		        <artifactId>junit</artifactId>
        		<version>4.12</version>
		        <scope>test</scope>
      		</dependency> 
      	 	<dependency>
          		<groupId>io.appium</groupId>
          		<artifactId>java-client</artifactId>
	            <version>3.1.0</version>
      		</dependency>
       </dependencies>
        ```
	
### Running Your Tests Locally
First make sure that you have followed all the steps in the Appium getting started guide above. 

Use the bash script provided to run the Appium server locally. Once the server is loaded, run the TestNG/Junit tests within your IDE.

To load the server manually use the command

Assume that your package name is **com.appium.example**, your main activity name is "**.Activities.MainActivity**" and the absolute filepath to your APK is    **~/Desktop/appium/app.apk**"

```
appium --pre-launch --app-pkg com.appium.example --app-activity .Activities.MainActivity --platform-name Android --app ~/Desktop/appium/app.apk
```

### Running Your Tests on Device Farm
#### Step 0: Verify the Project Set-up
First Read the [Device Farm documentation](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-calabash.html). Check if all the steps are completed and that your project and POM file are set up correctly. 

#### Step 1: Go into your Maven Appium Directory
Go into your Appium Maven project in the terminal or command prompt.

#### Step 2: Package the Maven 
Run the following command to package the test content
```
mvn clean package -DskipTests=true
```
#### Step 3: Find the zip-with-dependencies.zip file
Once the Maven command above is finished it should produce a "zip-with-dependencies.zip" file in your target folder (provided you followed the set-up above)


<img src="file:///Users/scottgo/mov/appium-tests.gif" width="400">

## Strategies For Android 

### Strategies for Testing Specific Scenarios

|Component |Android Implementation| Tests |
|----------|----------------------|-------|
|Alerts: [Toasts](http://developer.android.com/guide/topics/ui/notifiers/toasts.html) and [Dialogs](http://developer.android.com/guide/topics/ui/dialogs.html)   | [source code]()              |[source code]()
|Fixtures|[source code]()|[source code]()
|Static Page: [TextView](http://developer.android.com/reference/android/widget/TextView.html)|[source code]()|[source code]()
|Login Page|[source code]()|[source code]()
|Nested Views: [Back and Up Navigation](http://developer.android.com/design/patterns/navigation.html)|[source code]()|[source code]()
|[Web Views](http://developer.android.com/reference/android/webkit/WebView.html)|<ul><li><a href ="">Hybrid Web Views</a></li><li><a href="">Web View</a></li></ul>|<ul><li><a href ="">Hybrid Web Views</a></li><li><a href="">Web View</a></li></ul>

### Strategies for Native Features

|Feature |Android Implementation| Tests |
|--------|----------------------|-------|
|[Camera](http://developer.android.com/guide/topics/media/camera.html)  |[source code]() |[source code]()
|[Image Collection Grid](http://developer.android.com/guide/topics/ui/layout/gridview.html)|[source code]()|[source code]()
|[Scroll View](http://developer.android.com/reference/android/widget/ScrollView.html)|[source code]()|[source code]()
|Out of View Content|[source code]()|[source code]()
|[Video](http://developer.android.com/reference/android/media/MediaPlayer.html)|[source code]()|[source code]()

### Strategies for Testing Inputs

|Component |Android Implementation| Tests|
|--------------|---------|----------|
|[Checkbox](http://developer.android.com/reference/android/widget/CheckBox.html)|[source code]()|[source code]()|
|[DatePicker](http://developer.android.com/reference/android/widget/DatePicker.html)|[source code]()|[source code]()|
|[EditText](http://developer.android.com/reference/android/widget/EditText.html)|[source code]()|[source code]()|
|[Gestures Input](http://developer.android.com/training/gestures/index.html)|[source code]()|[source code]()|
|[Pull to Refresh](https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html)|[source code]()|[source code]()|
|[Radio Buttons](http://developer.android.com/guide/topics/ui/controls/radiobutton.html)|[source code]()|[source code]()|
|[TimePicker](http://developer.android.com/reference/android/widget/TimePicker.html)|[source code]()|[source code]()|
|[Toggle Button](http://developer.android.com/guide/topics/ui/controls/togglebutton.html)|[source code]()|[source code]()|

### Strategies for Automated Navigation
|Component |Android Implementation| Test
|--------------|---------|----------|
|[Navigation Drawer](https://developer.android.com/training/implementing-navigation/nav-drawer.html)|[source code]()|[source code]()|
|[ViewPager](http://developer.android.com/reference/android/support/v4/view/ViewPager.html)|[source code]()|[source code]()|

## Tips and Tricks
#### Driver Configuration
Remember to set up your Appium driver correctly. AWS Device Farm takes care of all the configuration for you. You shouldn't have to set any of the DesiredCapabilities when creating the driver. Refer to this **[code example]()**

