const express = require('express');
const app = express();

app.use(express.json())

app.use(
    express.urlencoded({
        extended: true
    })
)

app.post("/createEvent", (req, res) => {
    const service = require('./services/createBudget.js');
    service.create(req, res);
})

app.get("/voteEvent", (req, res) => {
    
})

app.post("/getEvent", (req, res) => {

})

app.listen(8080, () => {
    console.log("Server Started");
    let name = "db.sqlite";
})