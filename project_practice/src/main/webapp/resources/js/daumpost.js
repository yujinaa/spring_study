	function daumPost() {
		new daum.Postcode({
			oncomplete : function(data) {
				//R:도로명, J: 지번
				console.log("data.userSelectedType : " + data.userSelectedType)
				console.log("data.roadAddress : " + data.roadAddress)
				console.log("data.jibunAddress : " + data.jibunAddress)
				console.log("data.zonecode(우편번호) : " + data.zonecode)
				var addr = "" //db컬럼이 한개라 한개로 합치기위해 만든 변수
				if (data.userSelectedType == 'R') {//사용자가 도로명을 선택했다면
					addr = data.roadAddress//도로명으로
				} else {//아니라면
					addr = data.jibunAddress//지번으로
				}
				$("#addr1").val(data.zonecode)
				$("#addr2").val(addr)//사용자 선택값에 따라 들어감
				$("#addr3").focus()//addr3에 포커스 맞추기
			}
		}).open();
	}