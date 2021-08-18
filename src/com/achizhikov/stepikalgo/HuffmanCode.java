package com.achizhikov.stepikalgo;

import java.util.*;

public class HuffmanCode {
    class Node implements Comparable<Node> {
        private Node left;
        private Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "letter=" + letter +
                    ", frequency=" + frequency +
                    '}';
        }

        private Character letter;
        private int frequency;
        private String code;

        public Node(Character letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Character getLetter() {
            return letter;
        }

        public void setLetter(Character letter) {
            this.letter = letter;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.getFrequency() - o.getFrequency();
        }
    }

    private String encode(String string, Map<Character, String> letterAndCodes) {
        StringBuilder encodedString = new StringBuilder("");
        for (int i = 0; i < string.length(); i++) {
            encodedString.append(letterAndCodes.get(string.charAt(i)));
        }
        return encodedString.toString();
    }

    private void setCodes(String code, Node node, Map<Character, String> lettersAndCodes) {
        if (node.getLeft() != null) {
            setCodes(code + "0", node.getLeft(), lettersAndCodes);
            setCodes(code + "1", node.getRight(), lettersAndCodes);
        } else {
            lettersAndCodes.put(node.getLetter(), code.equals("") ? "0" : code);
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        Map<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character currentChar = string.charAt(i);
            letters.put(currentChar, letters.getOrDefault(currentChar, 0) + 1);
        }
        ArrayList<Node> nodes = new ArrayList<>();
        letters.forEach((key, value) -> nodes.add(new Node(key, value)));

        Node root = nodes.get(0);
        while (nodes.size() > 1) {
            Node left = Collections.min(nodes);
            nodes.remove(left);
            Node right = Collections.min(nodes);
            ;
            nodes.remove(right);
            root = new Node(null, left.getFrequency() + right.getFrequency());
            root.setLeft(left);
            root.setRight(right);
            nodes.add(root);
        }

        Map<Character, String> lettersAndCodes = new HashMap<>();
        setCodes("", root, lettersAndCodes);

        String encodedString = encode(string, lettersAndCodes);

        System.out.println(letters.size() + " " + encodedString.length());
        for (Character character : lettersAndCodes.keySet()) {
            System.out.println(character + ": " + lettersAndCodes.get(character));
        }
        System.out.println(encodedString);
    }

    public static void main(String[] args) {
        new HuffmanCode().run();
    }
}
