import 'package:flutter/material.dart';

class Info {
  final int id;
  final String userName;
  final int account;
  final int balance;

  Info({required this.id, required this.userName,
  required this.account, required this.balance});

  factory Info.fromJson(Map<dynamic, dynamic> json) {
    // 현재 클래스로 만든 객체를 리턴해줘야 한다.
    return Info(
        id: json['id'],
        userName: json['userName'],
        account: json['account'],
        balance: json['balance']
    );
  }
}