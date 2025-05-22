import apiClient from './api/clientInstance';
import { useDispatch, useSelector } from 'react-redux';
import { addUser } from './searchSlice';

export default function AddJoinInfo() {
	const dispatch = useDispatch();
	const userList = useSelector((state) => state.userSearch.userList);

	const handleSubmit = async (e) => {
		e.preventDefault();

		const data = {
			userid: e.target.userid.value,
			username: e.target.username.value,
			mobile1: e.target.mobile1.value,
			mobile2: e.target.mobile2.value,
			birthyear: Number(e.target.birthyear.value),
			height: Number(e.target.height.value),
			addr: e.target.addr.value,
			mdate: e.target.mdate.value
		};

		try {
			const response = await apiClient.post("/add-userinfo/add-join", data);
			dispatch(addUser(response.data));
			alert("고객 정보가 추가되었습니다.");
			e.target.reset();
		} catch(error) {
			console.log(error);
			alert("가입 실패했습니다. 다시 시도해주세요.");
		}
	}

	const handleCheck = async (e) => {
		e.preventDefault();

		const userid = document.getElementById('userid').value;

		if (!userid) {
			alert("아이디를 입력해주세요.");
			return;
		}

		const isDuplicate = userList.find((user) => user.userid === userid);
		if (isDuplicate) {
			alert("이미 사용 중인 아이디입니다.");
		} else {
			alert("사용 가능한 아이디입니다.")
		}
	}

	return (
		<>
		<form onSubmit={handleSubmit}>
			<ul className='detail-input-list'>
				<li>
					<label for='userid'>고객아이디</label>
					<input id='userid' name='userid' type='text' required/>
					<button onClick={handleCheck}>중복체크</button>
				</li>
				<li>
					<label for='username'>고객이름</label>
					<input id='username' name='username' type='text' required/>
				</li>
				<li>
					<label>전화번호</label>
					<input id='mobile1' name='mobile1' type='text' required/>
					<input id='mobile2' name='mobile2' type='text' required/>
				</li>
				<li>
					<label for='birthyear'>출생년도</label>
					<input id='birthyear' name='birthyear' type='text' required/>
				</li>
				<li>
					<label for='height'>신장</label>
					<input id='height' name='height' type='text' required/>
				</li>
				<li>
					<label for='addr'>거주지역</label>
					<input id='addr' name='addr' type='text' required/>
				</li>
				<li>
					<label for='mdate'>가입일자</label>
					<input id='mdate' name='mdate' type='date' required/>
				</li>
			</ul>
			<button type='submit'>추가하기</button>
		</form>
		</>
	);
}