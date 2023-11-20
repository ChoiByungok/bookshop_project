# bookshop_project
인프런 김영한 강사님의 JPA 강의에서 나온 예제를 가지고 살을 덧붙여 진행하는 개인용 프로젝트 입니다. <br>

# 기술스택 
<div>
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"> 
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white">
<img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white">
<img src="https://img.shields.io/badge/hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white">
<img src="https://img.shields.io/badge/Querydsl-008FC7?style=for-the-badge&logo=Querydsl&logoColor=white">
<br>
  </div>

# ERD
![image](https://github.com/ChoiByungok/bookshop_project/assets/113900701/fd61b8e9-4578-48a9-8263-1f94d8c446ee)

# 추후 넣을 기능
1. 상품 검색 QueryDsl을 이용한 동적쿼리 생성 예정입니다.<br>
2. jwt를 사용하여 로그인을 구현해볼 예정입니다.<br>
3. 모니터링 툴을 도입시켜볼 예정입니다. <br>

# 2023 11-10 커밋 내용
기존에 @ManyToMany로 매핑되어있던 엔티티를 @OneToMany @ManyToOne 관계로 바꿨습니다.<br> <br>
아이템 등록시 상위 카테고리를 같이 입력받아 현재 카테고리와 부모 자식 관계를 맺을 수 있도록 수정했습니다.
![image](https://github.com/ChoiByungok/bookshop_project/assets/113900701/efe7170d-939b-4f54-8c93-6a31dae688d0) <br> <br>
아이템 검색 시 카테고리도 같이 나올 수 있도록 구현했습니다.
```
{
        "name": "스프링",
        "price": 10000,
        "stockQuantity": 100,
        "categories": [
            {
                "categoryName": "스프링"
            }
        ],
        "author": "최병옥",
        "isbn": "1234-567"
    }
```
해당 카테고리만 나오게 되어있는데 상위 카테고리가 존재 할 시 모두 나올 수 있도록 수정 할 예정입니다.
