import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:stack/config/palette.dart';
import 'package:stack/signin_signup_provider.dart';

class Oauth2 extends StatelessWidget {
  const Oauth2({super.key});

  @override
  Widget build(BuildContext context) {
    SignInProvider provider = context.read<SignInProvider>();

    return Positioned(
      top: MediaQuery.of(context).size.height - 250,
      right: 0,
      left: 0,
      child: Column(
        children: [
          Text(provider.isSignUp? "or signUp with" : "or SignIn with"),
          SizedBox(
            height: 10,
          ),
          TextButton.icon(
            onPressed: (){},
            label: Text("Google"),
            icon: Icon(Icons.add),
            style: TextButton.styleFrom(
                backgroundColor: Palette.googleColor,
                foregroundColor: Colors.white,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                )
            ),
          ),
        ],
      ),
    );
  }
}
