package baseball;

import baseball.validator.NumbersValidator;
import com.sun.source.util.Trees;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

    static class Student implements Comparable {
        String name;
        int ban;
        int kor;
        int eng;
        int math;
        int no;

        Student(String name, int ban, int no, int kor, int eng, int math) {
            this.name = name;
            this.ban = ban;
            this.no = no;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        int getTotal() {
            return kor + eng + math;
        }

        float getAverage() {
            return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
        }

        public String toString() {
            return name
                    + "," + ban
                    + "," + no
                    + "," + kor
                    + "," + eng
                    + "," + math
                    + "," + getTotal()
                    + "," + getAverage()
                    ;
        }

        public int compareTo(Object o) {
            if (o instanceof Student) {
                Student tmp = (Student) o;
                return name.compareTo(tmp.name);
            } else {
                return -1;
            }
        }
    }

    class ex {
       public static int  getGroupCount(TreeSet tset, int from, int to) {
           Student a = new Student("", 0, 0, from, from, from);
           Student b = new Student("", 0, 0, to, to, to);
           return tset.subSet(a, b).size();
       }
    }

    @Test
    @DisplayName("입력값 맞는지")
    void input() throws Exception {
        //given
        NumbersValidator instance = NumbersValidator.getInstance();
        String input = "1235";
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            instance.validate(input);
        });

    }

    @Test
    @DisplayName("d")
    void bit() {

    }
}
