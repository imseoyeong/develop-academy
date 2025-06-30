import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:stack/signin_signup_provider.dart';

class Background extends StatelessWidget {
  const Background({super.key});

  @override
  Widget build(BuildContext context) {
    SignInProvider provider = context.watch<SignInProvider>();

    return Positioned(
      top: 0,
      right: 0,
      left: 0,
      child: Container(
        height: 300,
        decoration: BoxDecoration(
            image: DecorationImage(
                image: AssetImage("assets/red.jpg",),
                fit: BoxFit.fill
            )
        ),
        child: Container(
          padding: EdgeInsets.only(top: 90, left: 20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              RichText(
                text: TextSpan(
                    text:"Welcome",
                    style: TextStyle(
                      letterSpacing: 1.0,
                      fontSize: 25,
                      color: Colors.white,
                    ),
                    children: [
                      TextSpan(
                          text: provider.isSignUp? " to My Webpage!" : " back",
                          style: TextStyle(
                              letterSpacing: 1.0,
                              fontSize: 25,
                              color: Colors.white,
                              fontWeight: FontWeight.bold
                          )
                      )
                    ]
                ),
              ),
              SizedBox(
                height: 5,
              ),
              Text( provider.isSignUp? "SignUp to continue" : "SignIn to continue",
                style: TextStyle(
                    letterSpacing: 1.0,
                    color: Colors.white
                ),)
            ],
          ),
        ),
      ),
    );
  }
}
