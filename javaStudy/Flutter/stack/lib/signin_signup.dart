import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:stack/config/palette.dart';
import 'package:stack/signin_signup_provider.dart';

class SigninSignup extends StatelessWidget {
  const SigninSignup({super.key});

  @override
  Widget build(BuildContext context) {
    SignInProvider provider = context.watch<SignInProvider>();

    return Positioned(
        top: 180,
        child: Container(
          height: provider.isSignUp? 280 : 250,
          width: MediaQuery.of(context).size.width - 40,
          margin: EdgeInsets.all(20),
          padding: EdgeInsets.all(20),
          decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.circular(15),
            boxShadow: [
              BoxShadow(
                  color: Colors.black.withAlpha(100),
                  blurRadius: 10,
                  offset: Offset(5, 5)
              )
            ],
          ),
          child: SingleChildScrollView(
            padding: EdgeInsets.only(bottom: 30),
            child: Column(
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceAround,
                  children: [
                    GestureDetector(
                      onTap: (){
                        provider.isSignUp = false;
                      },
                      child: Column(
                        children: [
                          Text("SIGNIN",
                            style: TextStyle(
                                fontSize: 16,
                                fontWeight: FontWeight.bold,
                                color: !provider.isSignUp?
                                Palette.activeColor :
                                Palette.textColor1
                            ),),
                          if(!provider.isSignUp)
                            Container(
                              margin: EdgeInsets.only(top: 3),
                              height: 2,
                              width: 55,
                              color: Colors.orange,
                            )
                        ],
                      ),
                    ),
                    GestureDetector(
                      onTap: (){
                        provider.isSignUp = true;
                      },
                      child: Column(
                        children: [
                          Text("SIGNUP",
                            style: TextStyle(
                                fontSize: 16,
                                fontWeight: FontWeight.bold,
                                color: provider.isSignUp?
                                Palette.activeColor :
                                Palette.textColor1
                            ),),
                          if(provider.isSignUp)
                            Container(
                              margin: EdgeInsets.only(top: 3),
                              height: 2,
                              width: 55,
                              color: Colors.orange,
                            )
                        ],
                      ),
                    )
                  ],
                ),
                if(provider.isSignUp)
                  Container(
                    margin: EdgeInsets.only(top: 20),
                    child: Form(
                        key: provider.signUpFormKey,
                        child: Column(
                          children: [
                            TextFormField(
                              decoration: InputDecoration(
                                prefixIcon: Icon(Icons.account_circle,
                                    color: Palette.iconColor),
                                enabledBorder: OutlineInputBorder(
                                    borderSide: BorderSide(
                                        color: Palette.textColor1),
                                    borderRadius:
                                    BorderRadius.circular(35)
                                ),
                                hintText: "User name",
                                hintStyle: TextStyle(
                                    fontSize: 14,
                                    color: Palette.textColor2),
                                contentPadding: EdgeInsets.all(10),
                              ),
                              validator: (value){
                                if(value!.isEmpty || value.length <4){
                                  return "Please enter at least 4 charchters";
                                }
                                return null;
                              },
                              onSaved: (value){
                                provider.userName = value!;
                              },
                              key: ValueKey(1),
                            ),
                            SizedBox(
                              height: 10,
                            ),
                            TextFormField(
                              decoration: InputDecoration(
                                prefixIcon: Icon(Icons.email,
                                    color: Palette.iconColor),
                                enabledBorder: OutlineInputBorder(
                                    borderSide: BorderSide(
                                        color: Palette.textColor1),
                                    borderRadius:
                                    BorderRadius.circular(35)
                                ),
                                hintText: "email",
                                hintStyle: TextStyle(
                                    fontSize: 14,
                                    color: Palette.textColor2),
                                contentPadding: EdgeInsets.all(10),
                              ),
                              validator: (value){
                                if(value!.isEmpty || !value.contains("@")){
                                  return "Please enter a valid email address.";
                                }
                                return null;
                              },
                              onSaved: (value){
                                provider.userEmail = value!;
                              },
                              key: ValueKey(2),
                            ),
                            SizedBox(
                              height: 10,
                            ),
                            TextFormField(
                              decoration: InputDecoration(
                                prefixIcon: Icon(Icons.lock,
                                    color: Palette.iconColor),
                                enabledBorder: OutlineInputBorder(
                                    borderSide: BorderSide(
                                        color: Palette.textColor1),
                                    borderRadius:
                                    BorderRadius.circular(35)
                                ),
                                hintText: "Password",
                                hintStyle: TextStyle(
                                    fontSize: 14,
                                    color: Palette.textColor2),
                                contentPadding: EdgeInsets.all(10),
                              ),
                              obscureText: true,
                              validator: (value){
                                if(value!.isEmpty || value.length <6){
                                  return "Password must be at least 7 characters long.";
                                }
                                return null;
                              },
                              onSaved: (value){
                                provider.userPassword = value!;
                              },
                              key: ValueKey(3),
                            ),
                          ],
                        )),
                  ),
                if(!provider.isSignUp)
                  Container(
                    margin: EdgeInsets.only(top: 20),
                    child: Form(
                        key: provider.signInFormKey,
                        child: Column(
                          children: [
                            TextFormField(
                              decoration: InputDecoration(
                                prefixIcon: Icon(Icons.email,
                                    color: Palette.iconColor),
                                enabledBorder: OutlineInputBorder(
                                    borderSide: BorderSide(
                                        color: Palette.textColor1),
                                    borderRadius:
                                    BorderRadius.circular(35)
                                ),
                                hintText: "email",
                                hintStyle: TextStyle(
                                    fontSize: 14,
                                    color: Palette.textColor2),
                                contentPadding: EdgeInsets.all(10),
                              ),
                              validator: (value){
                                if(value!.isEmpty || !value.contains("@")){
                                  return "Please enter a valid email address.";
                                }
                                return null;
                              },
                              onSaved: (value){
                                provider.userEmail = value!;
                              },
                              key: ValueKey(4),
                            ),
                            SizedBox(
                              height: 10,
                            ),
                            TextFormField(
                              decoration: InputDecoration(
                                prefixIcon: Icon(Icons.lock,
                                    color: Palette.iconColor),
                                enabledBorder: OutlineInputBorder(
                                    borderSide: BorderSide(
                                        color: Palette.textColor1),
                                    borderRadius:
                                    BorderRadius.circular(35)
                                ),
                                hintText: "Password",
                                hintStyle: TextStyle(
                                    fontSize: 14,
                                    color: Palette.textColor2),
                                contentPadding: EdgeInsets.all(10),
                              ),
                              obscureText: true,
                              validator: (value){
                                if(value!.isEmpty || value.length <6){
                                  return "Password must be at least 7 characters long.";
                                }
                                return null;
                              },
                              onSaved: (value){
                                provider.userPassword = value!;
                              },
                              key: ValueKey(5),
                            ),
                          ],
                        )),
                  ),
              ],
            ),
          ),
        )
    );
  }
}
