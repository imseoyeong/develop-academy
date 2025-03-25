// [배열 구조 분해]

let x, y, z;
[x, y] = [1, 2];
console.log(x, y); // 1 2
[x, y] = [1];
console.log(x, y); // 1 undefined
[x, y] = [1, 2, 3];
console.log(x, y); // 1 2
[x, , z] = [1, 2, 3];
console.log(x, z); // 1 3 

// 기본값
[x, y, z = 3] = [1, 2];
console.log(x, y, z); // 1 2 3
[x, y = 10, z = 3] = [1, 2];
console.log(x, y, z); // 1 2 3
