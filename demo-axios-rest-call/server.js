const bodyparser = require('body-parser')
const express = require("express")
const path = require('path')
const axios = require('axios');

const app = express()
const employees=require('./objects/employees'); 
const employessroutes = require('./routes/employeeroutes');
const requestlogger = require('./utils/requestlogger');
var PORT = process.env.port || 3000
 
// View Engine Setup
app.set("views", path.join(__dirname + "/views"))
app.set("view engine", "ejs")
 
// Body-parser middleware
app.use(bodyparser.urlencoded({extended:false}))
app.use(bodyparser.json())


app.use(requestlogger)
app.use("/employee", employessroutes);
  
// app.get("/", function(req, res){
//     res.render("input",{content:''})
// });
  
app.get("/", function(req, res){
  res.json(employees)
});

// app.get('/saveData', (req, res) => {
//     nameinput=req.query.name;
    
//     axios.get('http://localhost:8080/greeting', {
//         params: {
//           name: nameinput
//         }
//       })
//       .then(function (response) {
//         res.render("input",response.data)
//       })
   

// })
   
app.post('/addemployee', (req,res)=>
{
  //let employeeList = new Array<employees>(empId, empName,empSalary);
  let emp=new employees(req.body.empName,req.body.empSalary);
  axios.post('http://localhost:8080/addemp', {
         emp

       })
       .then(function (response){
        res.render("AddEmployee", req.body)
       })
  
}
)

app.get('/findemployee', (req,res)=>
{
  
  let emp=new employees(req.body.empName,req.body.empSalary);
  axios.get('http://localhost:8080/find', {
         params: {
          name: empId
         }
       })
       .then(function (response){
        res.render("find-employee", response.data)
       })
  
})

app.listen(PORT, function(error){
    if (error) throw error
    console.log("Server created Successfully on PORT", PORT)
})




