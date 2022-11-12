@Changeprofile
Feature: Change Profile modulae API Automation

Scenario Outline: Changing Profile picture on changeprofilePic endpoint
Given User Should add Headers
And User Should add Form Data for changing profile picture
When User Should Send POST request for changeProfilepic endpoint
Then User Should verify the status code 200
And User Should verify the changing profile picture response body message "Profile updated Successfully"
