package com.example.policyspoon.base.initData;

import com.example.policyspoon.boundedContext.comment.entity.Comment;
import com.example.policyspoon.boundedContext.policy.entity.Policy;
import com.example.policyspoon.boundedContext.policy.repository.PolicyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner init(
            PolicyRepository policyRepository
    ) {
        return new CommandLineRunner() {
            @Override
            @Transactional
            public void run(String... args) {
                createPolicy("서울시 청년수당", "서울에 거주하고 있는 만 19세~34세 미취업 또는 단기 근로 청년에게 활동지원금(월 50만원 최대 6개월)을 지급하고, 강점진단 종합지원, 멘토링, 취업지원 프로그램 제공 등 청년 니즈에 맞게 프로그램 연계를 지속 지원하는 사업", "일자리분야", "ㅇ (금전적 지원) 매월 50만원 × 최대 6개월\n" +
                        "ㅇ 사용방법\n" +
                        "- 체크카드 사용이 원칙이며, 사업 목적에 부합한 범위에서 자유롭게 사용 가능\n" +
                        "- 현금사용은 금지되며, 특정 항목에 한하여 예외적 계좌이체 허용\n" +
                        "* (특정항목: ①주거(전·월세비, 주거 관리비, 주거 관련 대출), ②생활·공과금(전기·가스·수도요금, 통신비, 건강보험료), ③교육(학자금 대출, 자격증·시험 응시료) 에만 현금사용 가능, 나머지 항목엔 현금사용 금지\n" +
                        "\n" +
                        "- 현금으로 사용(계좌이체)한 경우 항목에 적합한 증빙서류를 자기활동기록서에 제출해야 하며, 개별적으로도 증빙자료를 2024.12.31.까지 보관 바람\n" +
                        "* 전·월세비 : 전·월세 관련 계약서 + 이체내역서\n" +
                        "* 전기·가스·수도요금, 건강보험료, 통신비 : 납부고지서 + 이체내역서\n" +
                        "* 주거 관련 대출, 학자금대출 납부 : 대출 계약서류 + 이체내역서\n" +
                        "* 자격증·시험 응시료 : 수험표 및 응시서류 + 이체내역서\n" +
                        "- 추후 모니터링을 통해 부정사용으로 적발될 시 청년수당 지급 중단 또는 환수 조치 예정\n" +
                        "\n" +
                        "ㅇ 유의사항\n" +
                        "- 진로탐색 및 구직활동 등 사업 목적에 맞게 사용, 사업 목적에 벗어난 용도(주점, 귀금속, 호텔, 재산축적 등) 사용 제한\n" +
                        "- 다른 통장으로 청년수당을 이체하여 사용하는 행위 금지\n" +
                        "- 호텔, 주점, 총포류 판매업, 카지노, 상품권 판매(기프티콘 포함), 귀금속, 백화점, 면세점, 안마시술소 등 유흥, 사행 목적 사용 금지\n" +
                        "- 청년수당 카드는 클린카드 기능이 적용되어 제한업종에서 결제가 되지 않습니다.\n" +
                        "- 개인재산 축적 용도 사용 제한: 예금, 적금, 민간보험·국민연금 납입, 상품권 구입(기프트콘 포함)\n" +
                        "- 서울 외 지역에서도 사용 가능하나, 해외 결제 불가\n" +
                        "※ 청년수당은 반드시 사업 목적에 맞게 사용해 주시기 바랍니다.\n" +
                        "\n" +
                        "ㅇ 청년수당 사용 불가 항목:\n" +
                        "- 지출내역 및 자금 흐름을 확인할 수 없도록 수당 사용\n" +
                        "(ex: 타계좌로 이체, 휴대폰 소액결제, 카카오페이, 더치페이 등),\n" +
                        "- 현금사용내역 증빙이 어려운 경우(중고거래, 경조사비, 종교 헌금, 기부 등),\n" +
                        "- 기타 사회 정서상 허용되기 어려운 용도로 수당사용(진로와 무관한 고가의 사치품 구입, 단순 미용 목적등)", "2024.03.~2024.12.", "2024년 03월 11일 ~ 2024년 03월 18일", "20,000명 내외", "2024년 03월 11일 10:00 ~ 2024년 03월 18일 16:00", "만 19세 ~ 34세", "□ 거주요건 : 신청일 기준, 서울시 주민등록상 거주자\n" +
                        "※ 사업 신청 시 기입한 신청자 주민등록번호로 서울거주 여부 일괄 조회\n" +
                        "※ 외국 국적 등 주민등록번호가 없는 청년은 신청 불가\n" +
                        "\n" +
                        "□ 신청연령 : 만 19세 ~ 만 34세(출생일이 1989년 3월 1일 ~ 2005년 3월 31일인 자)\n" +
                        "\n" +
                        "□ 소득요건 : 중위소득 150%이하\n" +
                        "\n" +
                        "□ 기타요건 :미취업자만 신청가능 단, 주30시간 이하 또는 3개월 이하 단기근로자 신청 가능\n" +
                        "※ 단, 주 30시간 이하 또는 3개월 이하 근로시간 확인이 가능한 별도의 증빙자료 (ex.근로계약서,퇴직증명서 등) 제출 시만 인정", "고교, 대학, 대학원 졸업(예정)\n" +
                        "최종학력 졸업", "제한없음", "미취업자, 단기근로자는 지원대상 포함(주 30시간 또는 3개월 이하로 계약된 근로자)", "제한없음", "취업여부 : 최종학력 졸업(중퇴·제적·수료) 후 미취업자\n" +
                        "미취업자(고용보험 미가입자) 및 단기근로자(주 30시간 이하 또는 3개월 이하로 근로계약된 근로자) 신청 가능\n" +
                        "- 고용보험에 가입된 단기근로자는 주 30시간 이하 또는 3개월 이하 근로시간 확인이 가능한 별도의 증빙자료(ex.근로계약서 등) 제출 시만 인정\n" +
                        "※ 사업참여 제외대상 : 공고문의 붙임 참고", "- 주민등록상 서울시 미거주자(신청 시점 기준)\n" +
                        "- 재학생 및 휴학생\n" +
                        "※ 단, 방송통신대학·사이버대학·학점은행제는 이전 최종학력 졸업 증빙하여 신청 가능\n" +
                        "- 고용보험에 가입된, 3개월 초과 그리고 주 30시간 초과 근로하는 취업자\n" +
                        "- 유사사업 참여중인 자 (2024년 3월 1일부터 사업 참여 종료일까지)\n" +
                        "· 서울시 ｢청년월세지원｣ 사업 참여자\n" +
                        "· 서울시 ｢희망두배 청년통장｣ 사업 참여자\n" +
                        "· 고용노동부 ｢청년내일채움공제｣ 사업 참여자\n" +
                        "· 고용노동부 ｢국민취업지원제도｣ 1유형 및 2유형 참여자\n" +
                        "- 2017년~2023년 서울시 청년수당 사업 참여자 (생애 1회 지원)\n" +
                        "- 중위소득 150% 초과 가구 청년\n" +
                        "※ ’24년 2월 건강보험료 본인부담금(노인장기요양보험료 제외) 기준\n" +
                        "\n" +
                        "- 기초생활수급자(생계·의료·교육·주거급여자) 및 차상위계층 (신청 시점 기준)\n" +
                        "- 실업급여 수급중인 자 (신청 시점 기준)\n" +
                        "\n" +
                        "* 2024년 2월까지 구직촉진수당을 받고 3월부터는 미수령 상태라면 청년수당 신청 가능합니다.", "서울청년몽땅정보통(youth.seoul.go.kr) 접속 후, 온라인 접수\n" +
                        "접수기간 내 온라인 신청만 가능(직접 접수 및 우편접수 등 불가능)\n" +
                        "\n" +
                        "△서울시 청년수당 콜센터(☎1566-3344)\n" +
                        "△서울시 다산콜센터(☎120)\n" +
                        "△온라인 서울청년몽땅정보통 ‘청년수당 Q&A’로 문의\n" +
                        "△ 온통청년 카카오톡 상담하기 (온라인 실시간 상담 이용하기➡ https://url.kr/r8bcva )", "선정 및 발표\n" +
                        "- 예비선정자 발표 : 4. 5.(금) 18:00 (예정)\n" +
                        "* 변동사항은 청년몽땅정보통 공지사항 게시판 안내\n" +
                        "* 확인방법 : 청년몽땅정보통 접속 후 “마이페이지”에서 확인\n" +
                        "- 필수 이행사항\n" +
                        "① 청년수당 참여자 사전교육\n" +
                        "② 계좌 개설 및 카드발급\n" +
                        "* 청년수당 전용계좌 미개설한 예비선정자는 최종 미 선정\n" +
                        "- 청년수당 1회차 첫 지급 : 4. 29.(월) (예정)\n" +
                        "* 매월 29일 지급 원칙(29일이 휴일인 경우, 직전 평일에 지급)", "https://youth.seoul.go.kr/youthPnsn/step1.do?key=2308160001", "□ 제출서류 (2종)\n" +
                        "※ 모든 제출서류는 원본 서류를 스캔하여 업로드, ‘화면캡쳐본, 컴퓨터 화면을 찍은 사진 등’은 인정되지 않음\n" +
                        "(필수) 최종학력 졸업증명서 또는 수료증 1부\n" +
                        "졸업예정자는 졸업 학점 이수 완료를 증빙할 성적증명서 또는 성적증명서+재학증명서를 대체 서류로 제출\n" +
                        "\n" +
                        "(선택) 근로계약서 1부 *단기근로자만 제출", "신청 시 기입 정보\n" +
                        "- 주민등록상 이름, 거주지, 연락처, 주민등록번호, 졸업일자 등 정확히 입력\n" +
                        "- 접수 후 주민등록상 정보와 다를 경우 선정 취소될 수 있음\n" +
                        "- 안내사항에 대한 문자를 받을 수 있도록 연락처 정확히 기재 필요", "서울시청 미래청년기획단", "주관기관과 동일", "https://youth.seoul.go.kr/youthConts.do?key=2310100061&sc_pbancSeCd=012&sc_bbsStngSn=2212200001&sc_bbsCtgrySn=2310200011&sc_qnaCtgryCd=004&sc_faqCtgryCd=005", "");
                createPolicy("상반기 동부기술교육원 직업교육훈련생 모집", "예비 취업준비시민의 직업능력 역량을 제고하고 서울산업 수요 맞춤형 인재를 양성", "교육분야", "□ 25개 학과 640명 모집\n" +
                        "※ 자세한 내용은 첨부파일 모집계획 참고\n" +
                        "\n" +
                        "□ 훈련생 지원\n" +
                        "ㅇ 수강료, 교재비, 실습비 등 교육훈련비 무료\n" +
                        "※ 일부 훈련과정에서 재료비 본인 부담 가능\n" +
                        "ㅇ 기술교육원 재학 중 국가기술자격시험 기능검정료 지원\n" +
                        "ㅇ 1일 5교시(월100시간)", "", "2024년 01월 08일 ~ 2024년 02월 16일", "25개 학과 640명", "20240108~20240216", "만 15세 이상", "□ 모집공고일 현재 서울시에 주민등록을 두고 있는 자로서 만 15세 이상인 서울시민(2009.01.08. 이전 출생자)\n" +
                        "※ 만15세 이상 만34세 이하 보호시설거주청년 또는 보호가 종료된 자립준비청년은 정원 외로 선발\n" +
                        "□ 서울시에 외국인 등록된 자로 영주권 취득자 또는 배우자가 내국인인 자 및 자녀", "제한없음", "제한없음", "제한없음", "제한없음", "", "신규 입학희망자에게 교육기회 제공을 위해 최근 3년 이내 입학자의 재입학은 아래와 같이 제한됨\n" +
                        "※ 재입학 금지 대상 : 2021.1.1.~2023.12.31. 중 수강 이력이 있는 자", "방문 또는 인터넷 접수", "□ 선발방법: 1차 서류전형(50점)+ 2차 개별면접(50점)+가점(0~5점)\n" +
                        "\n" +
                        "□ 합격발표 : ’24.2.23.(금) 오전 10:00(홈페이지 게시, 합격문자발송)", "http://new.cybervs.net/step1.html?school=complex", "응시원서 등 첨부파일 모집계획 참고", "", "서울시 동부기술교육원", "서울시 동부기술교육원", "", "");
                createPolicy("서울미래인재 모집", "새로운 서울을 설계하고 만들어나갈 미래인지 모집 및 양성", "참여.권리분야", "- 서울시에서 결정되는 중요한 정책을 자문·조정·심의·의결\n" +
                        "- 서울 시정에 참여하고자 하는 청년들을 모집하여 시정참여활동을 더 잘할 수 있도록 역량 강화프로그램을 제공", "", "2024년 01월 01일 ~ 2024년 12월 31일", "", "20240101~20241231", "만 19세 ~ 39세", "- 서울시에 거주 또는 서울을 기반으로 활동 중인 만 19~39세 청년", "", "", "", "", "", "", "", "□ 운영 절차\n" +
                        "미래인재 공개 모집(자격을 만족하는 청년 본인이 청년인재등록 신청) ▷ 미래인재 풀 구축(위원 위촉 추천을 위한 미래인재 데이터베이스 구축) ▷ 역량 강화 프로그램 운영(온라인 공통교육 및 분야별 특화 교육 실시) ▷ 인재위촉 추천(청년들이 지출할 위원회 수요조사 후 위촉 진행) ▷ 사후 지원(인재 간 네트워크 형성 및 청년위원의 위원회 활동 지원 ·환류)", "", "https://www.youth.seoul.go.kr", "", "서울시", "서울시", "https://www.youth.seoul.go.kr", "");
                createPolicy("서울 안심소득 참여가구 모집", "기준소득 대비 부족한 가계소득을 지원하는 소득 보장제도", "복지.문화분야", "□ 지원내용\n" +
                        "○ 가구별 기준 중위소득 85% 기준액과 가구의 소득평가액 간 차액의 절반(50%)을 지원\n" +
                        "○ 1인 가구의 경우 소득이 없으면 월 최대 947,090원\n" +
                        "○ 현금 인출이 가능한 체크카드로 지원\n" +
                        "○ 시범사업을 하는 1년 동안 매월 소득 및 가구변동 조사를 반영하여 조정된 안심소득액 지원", "", "2024년 01월 02일 ~ 2024년 01월 12일", "지원집단 500가구", "20240102~20240112", "만 9세 ~ 34세", "□ 소득, 재산 기준 동시 충족 가구\n" +
                        "○ 소득 기준 : 가구별 기준 중위소득 50% 이하\n" +
                        "○ 포함하는 소득 : 근로소득, 사업소득, 재산소득, 공적이전소득 등\n" +
                        "○ 재산 기준 : 326백만원(부채 차감) 이하", "", "", "", "", "", "", "서울복지포털(https://wis.seoul.go.kr)을 통해 신청", "", "https://wis.seoul.go.kr", "", "", "서울시", "서울시", "", "");
                createPolicy("기후동행카드", "서울 권역 내 모든 대중교통과 따릉이 무제한 이용 가능한 대중교통 정기권", "복지.문화분야", "□ 65,000원정기권(①서울 지역 내 지하철 ②서울시 면허 시내·마을버스 ③따릉이 무제한 이용 가능)\n" +
                        "□ 62,000원정기권(①서울 지역 내 지하철 ②서울시 면허 시내·마을버스)", "시범사업 사업기간 : 2024년 1월 27일(토) ~ 6월 30일(일)", "상시", "", "□ 1월 23일부터 모바일카드 다운로드 및 실물카드 판매 시작\n" +
                        "□ 1월 27일부터 서비스 본격 시작", "제한없음", "서울 시민 누구나", "", "", "", "", "□ 이용범위: 서울지역 지하철, 서울시 면허 시내·마을버스, 따릉이\n" +
                        "□ 이용제외: 신분당선, 서울지역 외 지하철, 광역/공항버스, 타 지역 면허버스\n" +
                        "※ 버스의 경우 서울시 면허 버스는 서울지역 외에서 승하차하더라도 기후동행카드 사용가능\n" +
                        "※ 지하철의 경우 서울지역 내 역에서 승차 후 서울지역 외 역에서 하차할 경우 기후동행카드 사용불가", "", "□ 모바일 카드\n" +
                        "[모바일 티머니 앱 다운로드] ▷ [회원가입] ▷ [기후동행카드 발급 및 충전]\n" +
                        "□ 실물카드\n" +
                        "[서울교통공사(1~8호선) 고객안전실 및 역사 인근 편의점 방문] ▷ [기후동행카드 구매] ▷ [티머니 카드&페이 홈페이지 등록] ▷ [구매한 카드를 역사 내 무인충전기에서 충전]", "", "", "", "※ 결제수단 : 모바일(계좌이체- 향후 결제수단 확대 예정), 실물카드(현금결제, 실물카드는 3,000원으로 별도 구매 필요, 최초 구매 후 매달 충전 사용)\n" +
                        "※ 실물카드 이용자는 반드시 '티머니 카드&페이' 홈페이지에 카드 등록 필요(1인 1카드 원칙)\n" +
                        "->카드 미등록 시 환불 및 따릉이 이용 불가", "서울시", "서울시", "https://news.seoul.go.kr/traffic/archives/510651", "");
                createPolicy("서울형 뉴딜 일자리", "일 경험 쌓고, 취업 역량도 키우는 뉴딜 일자리", "일자리분야", "□직무교육 + 일경험 제공 + 취창업 지원\n" +
                        "○임금 지급(서울형 생활임금 시급 11,436원)", "(근로기간)2024.4. ~ 2024.12.", "2024년 01월 08일 ~ 2024년 01월 12일", "□155개 사업장, 약 1,549명\n" +
                        "○5개 직무 분야등 (경영기획, 행정사무, 문화예술 경영, 돌봄, 교육상담, 특수분야)", "20240108~20240112", "만 18세 이상", "□만 18세 이상 서울시민 중 근로계약 시작일 현재 실업 상태인 자", "", "", "", "", "□2024년 2~3월 중 60시간 사전 교육 진행\n" +
                        "○수료자에 한해 근로계약 체결(집합교육에 한해 교육여비 일 25,000원 지급)", "", "서울일자리포털 사이트(https://job.seoul.go.kr) ▷ 서울형 뉴딜일자리 ▷ 모집 공고", "", "https://job.seoul.go.kr", "", "", "서울시", "서울시", "https://job.seoul.go.kr", "");
                createPolicy("서울시 청년동행센터", "금융문제로 어려움을 겪는 청년과 금융지식과 정보가 부족한 청년을 위해 파산,개인회생 등 공적채무조정지원 및 공공재무상담, 복지서비스 연계까지 맞춤형 통합서비스 제공", "복지.문화분야", "공적채무조정지원(개인회생,파산면책), 공공재무상담, 주거 및 일자리 복지서비스 연계\n" +
                        "1. 부채문제로 막막한 청년이라면? - 청년 채무상담 : 개인회생·파산·워크아웃 등 맞춤형 채무조정 상담 * 요건 충족 시 무료 법률지원\n" +
                        "2. 나에게 꼭 맞는 돈 관리가 필요하다면? - 청년 재무코칭 : 1:1 맞춤형 재무상담\n" +
                        "3. 청년을 위한 복지서비스가 궁금하다면? - 주거, 일자리, 심리 등 복지정보 제공 및 연계", "", "상시", "", "", "만 19세 ~ 39세", "", "제한없음", "제한없음", "제한없음", "제한없음", "※ 악성부채 채무조정상담, 공공재무상담, 일자리·주거·심리 등 복지서비스 연계 - 모든 상담비용 무료", "제한없음", "1644-0120 전화예약 홈페이지 [서울금융복지상담센터] - [온라인 일반상담 예약]", "상시", "https://sfwc.welfare.seoul.kr/", "", "", "복지정책실", "서울시복지재단", "https://sfwc.welfare.seoul.kr/", "https://blog.naver.com/sfwc-youth");
                createPolicy("서울시 청년안심주택(공공지원민간임대) 임대보증금 지원", "대중교통이 편리한 역세권 및 간선도로변에 청년, 신혼부부의 주거안정 및 주거난 해소를 위해 시세대비 저렴한 공공임대와 민간임대 주택을 제공", "주거분야", "- 임차보증금의 30% 무이자 지원(청년 : 최대 4,500만원, 신혼부부 : 최대 6,000만원)\n" +
                        "* 임차보증금이 1억원 이하인 경우 50% 무이자 지원(청년 및 신혼부부 : 최대 4,500만원)", "", "상시", "", "신규 입주(예정)일 3주 전까지 방문신청(평일 10:00 ~15:00 점심시간 없이 운영)", "만 19세 ~ 39세", "○ 소득기준(2024년 3월 1일 이후 접수자 기준)\n" +
                        "- 청년 : 신청자 본인(1인 가구) 소득 기준 전년도 도시근로자 가구원수별 가구당 월평균 100%이하(3,482,296원)\n" +
                        "- 신혼부부 : 신호부부 및 자녀 합산 소득 기준 전년도 도시근로자 가구원수별 가구당 월평균 소득 120%이하(2인가구:6,498,854원 / 3인가구:8.638.379원)\n" +
                        "○ 자산기준\n" +
                        "- 청년 : 신청자 본인 자산 기준 2억 7,300만원 이하\n" +
                        "- 신혼부부 : 신혼부부 및 자녀 합산 자산 기준 3억 4,500만원 이하", "제한없음", "제한없음", "제한없음", "제한없음", "", "", "○ 임대차 계약 후 청년안심주택 종합지원센터 방문신청(방문신청 시 지원약정서 작성 및 구비서류 제출)\n" +
                        "- 신청기간 : 신규 입주(예정)일 3주 전까지 방문 신청(평일 10:00~15:00 점심시간 없이 운영)\n" +
                        "- 신청장소 : 서울특별시 용산구 백범로99길 40, 용산베르디움프렌즈 102동(상가동) 2층, 청년안심주택 종합지원센터\n" +
                        "* 최초 계약 시는 입주개시(예저)일 3주전까지 방문 신청(최소 3주 기간 소요)\n" +
                        "- 문의전화 : 1600-3456", "", "", "서울시 청년안심주택(공공지원민간임대) 임대보증금 지원 신청 안내문 참고", "- 청년안심주택 임대보증금 예산 소진시 지원 불가\n" +
                        "- 청년안심주태(공공임대) 입주자 신청 불가\n" +
                        "- 청년안심주택 임대보증금 지원과 서울시 청년 신혼부부 임차보증금 이자지원사업 중복 신청 불가\n" +
                        "- 접수 후 입대차 계약 내용 변경 불가\n" +
                        "\n" +
                        "- 문의전화 : 1600-3456", "서울시청 전략주택공급과", "주관기관과 동일", "https://soco.seoul.go.kr/youth/main/contents.do?menuNo=400022", "");
                createPolicy("서울시 취업날개서비스 운영", "청년실업률 증가와 취업준비 기간 장기화로 구직과정에서 과중한 경제적 부담을 겪고 있는 청년들을 지원하기 위해 면접정장 무료대여 취업날개서비스 추진", "일자리분야", "면접용 정장 무료대여", "2024.01.01~2024.12.31", "2024년 01월 01일 ~ 2024년 12월 31일", "48,000명", "2024.01.01~2024.12.31", "만 15세 ~ 39세", "", "제한없음", "제한없음", "제한없음", "제한없음", "대여업체 문의가능 연락처\n" +
                        "- 드림윙즈(홍대점) 마포구 동교동 161-5, 3층(홍대입구역 1번출구 도보 1분) 02-547-4782\n" +
                        "- 마이스윗인터뷰(신촌점) 서대문구 신촌로 87-8, 3~4층(신촌역 1번출구 도보 1분) 070-8160-3010\n" +
                        "- 마이스윗인터뷰(사당점) 관악구 승방6길 34, 1층(사당역 5번출구 도보 5분) 02-522-3010\n" +
                        "- 마이스윗인터뷰(천호점) 강동구 천호대로151길 36, 8층(천호역 2번출구 도보 3분) 0507-1413-3027\n" +
                        "- 마이스윗인터뷰(영등포점) 영등포구 국회대로 547, 2층(영등포구청역 3번출구 도보 4분) 0507-1412-3027\n" +
                        "- 슈트 갤러리(논현점) 서초구 신반포로 337, 2~3층(논현역 5번출구 도보 1분) 02-3443-6009\n" +
                        "- 슈트 갤러리(충정로점) 서대문구 신촌로 37길 75, 1층(충정로역 7번출구 도보 3분) 02-363-6009\n" +
                        "- 스완제이(노원점) 노원구 동일로 1426, 5층(노원역 3번출구 도보 1분) 0507-1348-7108\n" +
                        "- 스타일딜리셔스(슈트패브릭, 청담점) 강남구 선릉로152길 32, 5층(압구정로데오역 4번출구 도보 10분) 070-4196-9606\n" +
                        "- 야베스컬렉션(이수점) 서초구 방배천로24길 17, 3층(이수역 5번출구 도보 5분) 02-1833-5389\n" +
                        "- 열린옷장(건대점) 광진구 아차산로 213, 5층(건대입구역 1번출구 도보 1분) 02-6929-1020\n" +
                        "- 체인지 레이디(왕십리점) 성동구 왕십리로 24나길 20, 4층(왕십리역 2번출구 도보 5분) 02-6204-1517\n" +
                        "- 체인지 레이디(강남점) 강남구 역삼로3길 17-6, 3층(강남역 4번출구 도보 5분) 070-5220-0307\n" +
                        "- 종로신사(종로점) 종로구 종로 223, 우교빌딩 4층(종로5가역 3번 출구 도보 1분) 02-743-1850\n" +
                        "(* 24년 개관)", "- 실제 회사 면접에 참여하는 경우만 대여 인정(대학원 면접 또는 모의면접에 참여할 경우 불인정)\n" +
                        "- 증빙서류가 없는 경우 대여 불가, 대여시 증빙서류 지참", "서울일자리포털 사이트 회원 로그인 후, 취업날개 사이트 이동하여 온라인 신청", "마이스윗인터뷰(신촌,사당,천호,영등포점) / 열린옷장(건대입구) / 체인지레이디(왕십리,강남) / 슈트갤러리(논현,충정로) / 스완제이(노원)/ 야베스컬렉션(이수) / 스타일딜리셔스(청담) / 드림윙즈(홍대)/ 종로신사(종로점) 14 곳에서 대여가 가능. 대여기간은 3박4일.", "\thttps://job.seoul.go.kr/www/add_service/openChothesChest.do?method=selectOpenChothesChest", "- 서울 거주 사실 혹은 서울 소재 학교 재학생·졸업생임을 증명할 수 있는 서류\n" +
                        "- 실제 면접을 보는 회사의 면접확인 서류를 회사명, 면접일, 연락처 등이 보여지도록 캡처하여 업로드\n" +
                        "- 전화로 면접을 통보받았을 경우 취업지원 사실을 확인할 수 있는 자료 제출", "연간 1인당 최대 10회까지 무료대여 가능 2회부터는 온라인 대여 가능, 처음 대여했을 때 측정했던 치수를 토대로 택배 또는 직접수령 가능", "경제일자리기획관 일자리정책과 청년일자리팀", "", "https://www.dressfree.net/main/main.php", "https://www.seoul.go.kr/seoul/mediahub_view.do?articleNo=2010040");
                createPolicy("청년 임차보증금 이자지원", "서울시에서는 청년들의 더 나은 주거환경과 소득 대비 높은 주거비 부담을 완화하기 위해 청년 임차보증금 이자지원을 제공합니다.", "주거분야", "○ 대출한도\n" +
                        "- 최대 2억원(임차보증금의 90% 이내, 대출한도 최대 2억원은 2023.5.2 대출 신청 건부터 적용됨)\n" +
                        "\n" +
                        "○ 지원금리\n" +
                        "- 대출금액의 연 2% 이자지원\n" +
                        "*본인부담금리: 대출금리 - 서울시 지원금리 (*본인 의무 부담금리 연 1.0%)\n" +
                        "\n" +
                        "○ 대출기간\n" +
                        "- 임차계약기간에 따라 회당 6개월~2년 (최장 8년까지 연장 가능)\n" +
                        "- 만 39세까지 대출 및 이자지원(만 40세가 되는 날부터 이자지원이 중단됨)\n" +
                        "- 예외: 대출만기 시점에 전세사기(깡통전세)로 인하여 대출금 상환이 어려울 경우 증빙서류 제출 시 대출연장 및 이자지원 연장처리(최장4년)\n" +
                        "\n" +
                        "○ 대출형식\n" +
                        "- 한국주택금융공사 보증서를 담보로 하나은행 재원으로 대출", "", "상시", "", "상시", "만 19세 ~ 39세", "○ 지원대상\n" +
                        "- 근로청년: 현재 근로 중인 자\n" +
                        "- 취업준비생 등: 현재 근로중이 아니면서, 과거 근로기간의 총합이 1년이상 있거나, 부모 연소득이 7천만원 이하인 자\n" +
                        "* 무주택: 신청인 기준(부모님 주택 소유여부와 무관)\n" +
                        "* 세대주: 주민등록등본 상 현재 세대주 또는 대출 실행 후 1개월 이내 세대주 예정자\n" +
                        "\n" +
                        "○ 주택조건\n" +
                        "- 서울시 관내에 위치한 주택 또는 주거용 오피스텔로서, 임차보증금 3억원 이하, 월세 70만원 이하의 전월세계약\n" +
                        "- 건축물대장상 주택이 아닌 곳과 불법건축물, 다중 주택, 공공임대주택은 지원 불가", "제한없음", "제한없음", "1) 근로청년: 현재 근로 중인 자\n" +
                        "2) 취업준비생 등: 현재 근로중이 아니면서, 과거 근로기간의 총합이 1년이상 있거나, 부모 연소득이 7천만원 이하인 자", "제한없음", "", "", "", "", "https://housing.seoul.go.kr/site/main/content/sh01_040901", "청년 임차보증금 이자지원사업 공고문 참고", "- 본 사업을 통한 대출은 생애 1회로 제한합니다. 추가 대출 및 전액 상환 후 재신청은 불가합니다.\n" +
                        "- 추천서를 받으셨다 하더라도 은행내규에 적합하지 않을 경우 대출취급이 제한될 수도 있습니다.\n" +
                        "- 서울시 다산콜센터 (☎02-120)\n" +
                        "- 서울시 주택정책과 (☎02-2133-7026, 7029)", "서울시 주택정책과", "주관기관과 동일", "https://soco.seoul.go.kr/youth/main/contents.do?menuNo=400024", "");
                createPolicy("서울시 청년 자립토대 지원사업", "개인회생 청년의 경제적 재기지원 및 재무역량강화를 위한 지원사업\n" +
                        "- 코로나19 이후 청년층의 가계부채 증가와 재무건전성 악화로 개인회생 신청이 증가하는 상황에서 금융취약 청년층의 재도산을 예방하고,\n" +
                        "신속한 경제적 재기를 지원하기 위한 사업\n" +
                        "- 청년 자립토대 지원사업 참가자에게는 ‘재무역량 강화를 위한 맞춤형 프로그램’과 ‘자립토대 지원금’ 100만원 제공", "복지.문화분야", "금융역량강화를 위한 온라인 금융교육 2회, 1:1 맞춤형 상담 3회, 자립토대지원금 100만원(50만원X2회) 지원\n" +
                        "\n" +
                        "○ (재무역량 강화 맞춤형 프로그램) 교육 및 맞춤형 상담\n" +
                        "- 재무역량 강화를 위한 금융교육 2회\n" +
                        "- 1:1 맞춤형 상담 3회 진행\n" +
                        "* 참가자별 상황에 따라 복지, 주거, 고용 등 서비스 연계 지원\n" +
                        "- 재무 상태 파악 및 재무 목표 설정, 금융상품 적정성 평가 및 분석, 소득·지출 관리, 실행사항 이행 여부 확인 및 모니터링\n" +
                        "○ (자립토대지원금) 100만원(50만원 × 2회) ※ 생애 1회 지원 원칙\n" +
                        "- 참가자 본인 계좌로 지급", "2024.3 ~ 2024.11", "2024년 03월 18일 ~ 2024년 04월 12일", "150명", "2024.3.18. ~2024. 4.12.", "만 19세 ~ 39세", "- (거주) 신청일 기준 서울시 거주\n" +
                        "- (연령) 만19세~39세\n" +
                        "- (소득) 중위소득 140% 이내\n" +
                        "- (회생여부) 개인회생중으로 3개월 이내 변제완료 예정 또는 1년 이내 면책결정을 받은 자\n" +
                        "- (취업) 신청일 기준 근로중인 자", "제한없음", "제한없음", "근로중인 청년", "제한없음", "", "미취업자, 취업예정자, 개인회생 3회 이상 미납자, 서울시복지재단 청년통장 참가중인자(사업 종료 후 신청가능), 중위소득 140% 초과 청년", "서울복지포털(wis.seoul.go.kr) 접속 후 신청", "2024년 5월 3일 예정", "https://wis.seoul.go.kr/", "참가자 본인 통장사본, 건강보험 자격 확인(통보)서, 건강보험 납부확인서, 변제현황조회 내역, 변제수행 납입증명원, 법원 사건조회 내역, 근로계약서 또는 일용근로 사실확인서", "", "서울특별시", "서울시복지재단", "https://wis.seoul.go.kr/was/ssy/selfRelianceInfo.do", "https://www.seoul.go.kr/news/news_notice.do#view/407912");
                createPolicy("서울청년문화패스", "사회에 첫 발을 내딛는 20세~23세 청년들에게 연극, 뮤지컬, 클래식·오페라, 발레·무용, 국악, 전시 관람 기회를 제공하고 문화예술분야 활성화를 위해 문화이용권을 지원하는 사업", "복지.문화분야", "공연과 전시 관람에 사용할 수 있는 1인당 연간 20만원 상당의 문화이용권(카드) 지급\n" +
                        "- 카드 발급일로부터 2024.12.31.까지\n" +
                        "* 예매 이용률과 예산 한도를 고려하여 조기마감 될 수 있음", "", "2024년 03월 28일 ~ 2024년 04월 17일", "30,000명\n" +
                        "20~23세 서울특별시 거주 청년", "2024. 3. 28.(목) ~ 4. 17.(수)", "만 20세 ~ 23세", "\t□ 나 이 : 20~23세\n" +
                        "ㅇ 2001. 1. 1. ~ 2004. 12. 31. 출생자\n" +
                        "□ 거주지 : 신청일 기준 서울특별시 거주\n" +
                        "ㅇ 주민등록 및 외국인등록대장 기준\n" +
                        "□ 소 득 : 2024년 2월 건강보험료 기준\n" +
                        "ㅇ 생애 최초 수혜자 : 본인부담금 기준 중위소득 150% 이하\n" +
                        "ㅇ 2023년 수혜자 : 본인부담금 기준 중위소득 120% 이하\n" +
                        "※ 신청시 제공한 주민등록번호(외국인등록번호)와 ‘개인정보 수집·이용 및 제3자 제공 동의’에 따라 모집 마감 후 국민건강보험공단에 일괄 조회\n" +
                        "※ 신청자가 지역 세대원 또는 직장 피부양자인 경우 부양자 부과액 기준\n" +
                        "※ 가구원수는 건강보험에 함께 등재된 사람을 기준으로 산정", "제한없음", "제한없음", "제한없음", "제한없음", "□ 신청하는 곳 : 청년몽땅정보통(youth.seoul.go.kr)에서 온라인 신청\n" +
                        "ㅇ 청년몽땅정보통 → 교육문화 → 서울청년문화패스 → 신청하기\n" +
                        "※ 장애인 등 온라인 신청이 어려운 취약계층은 콜센터를 통해 신청 가능 (☎ 1533-3427)\n" +
                        "※ 방문 신청이나 우편 신청 불가\n" +
                        "※ 콜센터는 평일 업무시간(9~12시 / 13~18시)에 이용 가능", "", "신청(온라인) → 자격확인·선정 → 카드발급(비대면) → 사용(결제)", "\t□ 발 표 일 : 2024. 5. 8.(수) 예정\n" +
                        "※ 발표일은 변동될 수 있으며, 자세한 내용은 청년몽땅정보통 공지사항 게시판 확인\n" +
                        "□ 발표방법 : 개별 문자 발송 및 청년몽땅정보통 ‘마이페이지’ 확인", "youth.seoul.go.kr", "ㅇ 온라인 신청 및 개인정보 제공 동의를 통한 비대면 자격확인으로 별도 제출서류 없음\n" +
                        "ㅇ 단, 외국국적동포의 경우 국내거소신고 사실증명서 첨부\n" +
                        "※ 원본 서류를 스캔 또는 다운로드 받아 업로드(화면 캡처, 사진 불인정)", "ㅇ 관람분야 : 공연(연극·뮤지컬·클래식·오페라·무용·국악), 전시\n" +
                        "ㅇ 관람방법 : 서울청년문화패스 홈페이지에서 예매 후 관람\n" +
                        "ㅇ 예매기준 : 예매 건당 7만원 이내 사용(추가금액 자부담)\n" +
                        "※ 뮤지컬은 지원기간 중 1회만 예매 가능\n" +
                        "\n" +
                        "ㅇ 서울청년문화패스 지원 신청 및 사용과 관련한 자세한 사항은 청년몽땅정보통 홈페이지에서 확인해 주시기 바랍니다.\n" +
                        "※ 콜센터 : ☎ 1533-3427 [평일 업무시간(9~12시/13~18시) 이용가능]\n" +
                        "※ 청년몽땅정보통 홈페이지 : https://youth.seoul.go.kr", "서울특별히 문화본부 문화정책과 시민문화팀", "", "https://www.youthcultureseoul.kr/eventExhibition/2079", "https://youth.seoul.go.kr/youthConts.do?key=2310200023&sc_pbancSeCd=005&sc_bbsStngSn=2212200001&sc_bbsCtgrySn=2310200005&sc_qnaCtgryCd=&sc_faqCtgryCd=002");
            }

            public Policy createPolicy(String title, String summary, String category, String supportDetail,
                                       String operationPeriod, String applyPeriod, String supportScale,
                                       String note, String age, String areaIncome,
                                       String education, String major, String employmentStatus,
                                       String specialization, String additionalClue, String restrictBoundary,
                                       String applicationProcess, String judgePresentation, String applicationSite,
                                       String submitDocument, String etcInformation, String hostOrganization,
                                       String operatingOrganization, String referenceSite1, String referenceSite2) {
                Policy policy = Policy.builder()
                        .title(title)
                        .summary(summary)
                        .category(category)
                        .supportDetail(supportDetail)
                        .operationPeriod(operationPeriod)
                        .applyPeriod(applyPeriod)
                        .supportScale(supportScale)
                        .note(note)
                        .age(age)
                        .areaIncome(areaIncome)
                        .education(education)
                        .major(major)
                        .employmentStatus(employmentStatus)
                        .specialization(specialization)
                        .additionalClue(additionalClue)
                        .restrictBoundary(restrictBoundary)
                        .applicationProcess(applicationProcess)
                        .judgePresentation(judgePresentation)
                        .applicationSite(applicationSite)
                        .submitDocument(submitDocument)
                        .etcInformation(etcInformation)
                        .hostOrganization(hostOrganization)
                        .operatingOrganization(operatingOrganization)
                        .referenceSite1(referenceSite1)
                        .referenceSite2(referenceSite2)
                        .build();

                return policyRepository.save(policy);
            }
        };
    }

}