import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'dart:async';
import './info.dart';

void main() {
  runApp(const MyApp());
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
  late Future<Info> _fetchData;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _fetchData = fetchInfo();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("계좌정보 확인하기"),
        centerTitle: true,
      ),
      body: Center(
        child: FutureBuilder(
            future: _fetchData,
            builder: (context, snapshot) {
              if(snapshot.connectionState == ConnectionState.done) {
                if(snapshot.hasData) {
                  return Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text("고객번호: " + snapshot.data!.id.toString(),
                        style: TextStyle(
                          fontSize: 20,
                        ),
                      ),
                      Text("고객명: " + snapshot.data!.userName,
                        style: TextStyle(
                          fontSize: 20,
                        ),
                      ),
                      Text("계좌번호: " + snapshot.data!.account.toString(),
                        style: TextStyle(
                          fontSize: 20,
                        ),
                      ),
                      Text("잔액: " + snapshot.data!.balance.toString(),
                        style: TextStyle(
                          fontSize: 20,
                        ),
                      ),
                    ],
                  );
                } else if(snapshot.hasError) {
                  return Text("${snapshot.error}");
                }
              }
              return CircularProgressIndicator();
            }
        ),
      ),
    );
  }
  
  Future<Info> fetchInfo() async {
    Uri url = Uri.parse("https://my.api.mockaroo.com/bank.json?key=fea24270");
    final response = await http.get(url);
    if(response.statusCode == 200) {
      return Info.fromJson(json.decode(response.body)); // json.decode: 맵 데이터 형식으로 바꿔줌?
    } else {
      throw Exception("계좌정보를 불러오는데 실패했습니다.");
    }
  }

}

