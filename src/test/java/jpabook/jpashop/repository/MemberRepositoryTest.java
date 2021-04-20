package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {
    static Logger log = LoggerFactory.getLogger(MemberRepositoryTest.class);

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @DisplayName("멤버 정보를 등록했을 때 등록된 멤버의 ID가 조회시 ID와 같다")
    @Rollback(false)
    void save() {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        final Long id = memberRepository.save(member);
        Member memberSaved = memberRepository.findOne(id);

        //then
        assertThat(memberSaved.getId()).isEqualTo(member.getId());
        assertThat(memberSaved.getUsername()).isEqualTo(member.getUsername());

    }

    @Test
    void find() {
        assertThat(1).isEqualTo(1);
    }
}