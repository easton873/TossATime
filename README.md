To run the app locally:
run the following three commands from the main repository folder:

`cd tossatime`

`npm install`

`npm install react-router-dom --save`

Then run the command:

`npm start`


To launch the server in EC2 first

`mvn compile`

and then

`sudo mvn exec:java -Dexec.mainClass=Server -Dexec.args="80"`

then in a separate window connect to the EC2 instance again and

`cd tossatime`

`npm install`

`npm run build`

`serve -s build`