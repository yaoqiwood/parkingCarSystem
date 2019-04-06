function hello() {
    this.a = function () {  
        console.log("hello");
    }
}

var o = function () { 
    console.log("aaaaaa");
 }