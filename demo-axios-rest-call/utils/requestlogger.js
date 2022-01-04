

const requestlogger = (req, res, next) => {
    if(req){
        console.log(new Date().toUTCString() + " |-- Method:" + req.method + " -- " + req.path + " ")
    }

    next();
}

module.exports = requestlogger;