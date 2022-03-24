
const num1 = prompt("Enter first number: ");
const num2 = prompt("Enter second number: ");
const num3 = prompt("Enter third number: ");
let largest;
if(num1 >= num2 && num1 >= num3) {
    largest = num1;
}
else if (num2 >= num1 && num2 >= num3) {
    largest = num2;
}
else {
    largest = num3;
}
console.log("The largest number is " + largest);
************************************************
function reverseString(str) {

    let newStr = "";
    for (let i = str.length - 1; i >= 0; i--) {
        newStr = newStr+str[i];
    }
    return newStr;
}

const string = prompt('Enter a string: ');

const result = reverseString(string);
console.log(result);