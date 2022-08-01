# resumeScreening
Maven Java project to screen resume files with defined criteria.

# **Resume Screening Application**

This is a console based Maven Java application.

The application is capable of reading the resume files in PDF/Doc/Docx file formats stored under ./data/resumes directory path, and search for the keywords defined in the "RSAConfig.xml" file.

The Application will generate results in the "Result.csv" file, stored under ./data/output directory path.

## **Input Configuration**
The Application input can be configured through the RSAConfig.xml file.

Currently, the Application is capable to filter the Skill, Qualification and Experience range as the eligibility criteria.
Hence, the user can modify/add the values for the above mentioned criteria types in the XML file.

Copy all the resume files that need to be screened, under ./data/resumes directory path.


## **Execution Steps**

#### 1.Clone the project repository to the local machine

    git clone https://github.com/externship-sag/resumeScreening.git
    
#### 2.Import the project source code from the File system to eclipse
  
    Open eclipse ->File ->Import->Existing Maven Projects->Select Next-> Browse the git cloned Directory beside "Root Directory" text field.->Finish

    Now the project code is added to Project Explorer pane.

#### 3.Execute the application as Java application
    a. Copy the resume files into the data/resumes folder
    
    b. Run "maven build" with configuration goals as "clean compile assembly:single" configuration. 
       After succesful build, the jar file will be generated in the target folder. 
    
    c. Either Run as java application to test the application.
       (or)
       Use the below command to execute the application jar file from the command line:
       java -jar target/resumeScreeningApp-1.0-SNAPSHOT-jar-with-dependencies.jar
    

