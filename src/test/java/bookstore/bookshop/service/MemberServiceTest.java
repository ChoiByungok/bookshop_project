package bookstore.bookshop.service;

import bookstore.bookshop.domain.Member;
import bookstore.regacy.service.MemberService;
import bookstore.regacy.service.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입")
    void join() {
        Member member = new Member();
        member.setName("kim");

        Long savedId = memberService.join(member);

        assertThat(member).isEqualTo(memberRepository.findOne(savedId));
    }

    @Test
    @DisplayName("증복 회원 예외")
    void duplicated() {
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class);

    }
}