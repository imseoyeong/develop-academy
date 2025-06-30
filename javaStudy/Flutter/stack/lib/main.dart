import 'package:flutter/material.dart';
import 'package:stack/background.dart';
import 'package:stack/config/palette.dart';
import 'package:stack/oauth2.dart';
import 'package:stack/signin_signup.dart';
import 'package:stack/submit.dart';
import 'package:provider/provider.dart';
import './signin_signup_provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (context) => SignInProvider(),
      child: MyApp(),
    )
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: MyPage(),
    );
  }
}

class MyPage extends StatefulWidget {
  const MyPage({super.key});

  @override
  State<MyPage> createState() => _MyPageState();
}

class _MyPageState extends State<MyPage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Background(),
          SigninSignup(),
          Submit(),
          Oauth2(),
        ],
      ),
    );
  }
}
