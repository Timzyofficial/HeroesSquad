package models;

public class Hero {
    package models;

import java.util.ArrayList;
import java.util.List;

    public class Hero {
        private static int nextId = 1;

        private int id;
        private int age;
        private String name;
        private String power;
        private String weakness;

        private int squadId;

        public static List<Hero> heroes = new ArrayList<>();

        public Hero(int age, String name, String power, String weakness) {
            this.age = age;
            this.name = name;
            this.power = power;
            this.weakness = weakness;
            id = nextId ++;
            squadId = -1;
        }

        public int getSquadId() {
            return squadId;
        }

        public void setSquadId(int squadId) {
            this.squadId = squadId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getWeakness() {
            return weakness;
        }

        public void setWeakness(String weakness) {
            this.weakness = weakness;
        }
    }
}
