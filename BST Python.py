# We are using Selenium in this program to create a couple of basic tests and use Browserstack Cloud for setup of various Browsers 

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

desired_cap_1 = {
    "os" : "OS X",
    "osVersion" : "Big Sur",
    "browserName": "Safari",
    "browserVersion": "14.1",
    "buildName" : "browserstack-build-1",
    "sessionName" : "BStack local python",
    "local" : "true",
}


desired_cap_2= {
    "os" : "Windows",
    "osVersion" : "11",
    "buildName" : "browserstack-build-1",
    "sessionName" : "BStack local python",
    "browserName": "Firefox",
    "browserVersion": "112.0",
    "local" : "true",
}

desired_cap_3= {
    "os" : "OS X",
    "osVersion" : "Mojave",
    "buildName" : "browserstack-build-1",
    "browserName": "Chrome",
    "browserVersion": "111.0",
    "sessionName" : "BStack local python",
    "local" : "true",
}

desired_cap_4= {
    "os" : "Windows",
    "osVersion" : "11",
    "buildName" : "browserstack-build-1",
    "browserName": "Edge",
    "browserVersion": "112.0",
    "sessionName" : "BStack local python",
    "local" : "true",
}


# To run test locally

driver_5 = webdriver.Chrome('./chromedriver') 
driver_5.get("https://www.browserstack.com")
print (driver_5.title)
elem = driver_5.find_element("id","signupModalButton")
elem.click()
print (driver_5.title)
assert "https://www.browserstack.com/users/sign_up" == driver_5.current_url
driver_5.quit()

driver_6 = webdriver.Firefox() 
driver_6.get("https://www.browserstack.com")
print (driver_6.title)
elem = driver_6.find_element("id","signupModalButton")
elem.click()
print (driver_6.title)
assert "https://www.browserstack.com/users/sign_up" == driver_6.current_url, "Incorrect URL"
driver_6.quit()

driver_7 = webdriver.Safari() 
driver_7.get("https://www.browserstack.com")
print (driver_7.title)
elem = driver_7.find_element("id","signupModalButton")
elem.click()
print (driver_7.title)
assert "https://www.browserstack.com/users/sign_up" == driver_7.current_url, "Incorrect URL"
driver_7.quit()


#To test run on BrowserStack in different enviroment (Browsers, OS)

driver_1 = webdriver.Remote(
command_executor='https://ankurchauhan_D2EYax:uof4xMvWDZMrLsExAzfc@hub.browserstack.com/wd/hub',
desired_capabilities=desired_cap_1)
driver_1.get("https://www.google.com")
if not "Google" in driver_1.title:
    raise Exception("Unable to load google page!")
elem = driver_1.find_element("name","q")
elem.send_keys("BrowserStack")
elem.submit()
print (driver_1.title)
driver_1.quit()

driver_2 = webdriver.Remote(
command_executor='https://ankurchauhan_D2EYax:uof4xMvWDZMrLsExAzfc@hub.browserstack.com/wd/hub',
desired_capabilities=desired_cap_2)
driver_2.get("https://www.browserstack.com")
elem = driver_2.find_element("id","signupModalButton")
elem.click()
print (driver_2.title)
assert "https://www.browserstack.com/users/sign_up" == driver_2.current_url
driver_2.quit()

#This test is to intentionally test an incorrect assesment
driver_3 = webdriver.Remote(
command_executor='https://ankurchauhan_D2EYax:uof4xMvWDZMrLsExAzfc@hub.browserstack.com/wd/hub',
desired_capabilities=desired_cap_3)
driver_3.get("https://www.browserstack.com")
elem = driver_3.find_element("id","signupModalButton")
elem.click()
print (driver_3.title)
try:
    assert "https://www.browserstack.com/sign_up" == driver_3.current_url, "Signup Link is incorrect"
finally:
    driver_3.quit()

driver_4 = webdriver.Remote(
command_executor='https://ankurchauhan_D2EYax:uof4xMvWDZMrLsExAzfc@hub.browserstack.com/wd/hub',
desired_capabilities=desired_cap_4)
driver_4.get("https://www.Google.com/")
elem = driver_4.find_element("name","q")
elem.click()
print (driver_4.title)
assert "Google" == driver_4.title
driver_4.quit()
