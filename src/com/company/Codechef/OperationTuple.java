package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class OperationTuple {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] ini = br.readLine().trim().split(" ");
                String[] fin = br.readLine().trim().split(" ");
                int[] initial = {Integer.parseInt(ini[0]), Integer.parseInt(ini[1]), Integer.parseInt(ini[2])};
                int[] finalA = {Integer.parseInt(fin[0]), Integer.parseInt(fin[1]), Integer.parseInt(fin[2])};
                int res = solution(initial, finalA);
                System.out.println(res);
            }
        } catch (Exception e) {

        } finally {

        }
    }

    static int solution(int[] initial, int[] finalA) {
        boolean[] vis = new boolean[3];
        int lowest = 0;
        int k = -1;
        for (int i = 0; i < 3; i++) {
            if (initial[i] > finalA[i]) {
                lowest++;
            }
        }
        if (lowest == 0) {
            for (int i = 0; i < 3; i++) {
                if (initial[i] == finalA[i]) {
                    vis[i] = true;
                } else {
                    vis[i] = false;
                }
            }
        } else if (lowest == 1) {

            for (int i = 0; i < 3; i++) {
                if (initial[i] > finalA[i]) {
                    vis[i] = true;
                    k = i;
                } else {
                    vis[i] = false;
                }
            }
        } else if (lowest == 2) {
            for (int i = 0; i < 3; i++) {
                if (initial[i] > finalA[i]) {
                    int temp = initial[i];
                    initial[i] = finalA[i];
                    finalA[i] = temp;
                    vis[i] = false;
                } else {
                    vis[i] = true;
                    k = i;
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                int temp = initial[i];
                initial[i] = finalA[i];
                finalA[i] = temp;
                vis[i] = false;
            }
        }
        int res = solutionUtil(initial, finalA, vis);
        if (lowest == 0 || lowest == 3) {
            return res;
        } else if (lowest == 1) {
            int r = initial[k] % finalA[k];
            int q = initial[k] / finalA[k];
            if (q != 0) {
                res++;
            }
            if (r != 0) {
                res++;
            }
            return res;
        } else {
            int r = finalA[k] % initial[k];
            int q = finalA[k] / initial[k];
            if (q != 0) {
                res++;
            }
            if (r != 0) {
                res++;
            }
            return res;
        }
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int solutionUtil(int[] initial, int[] fin, boolean[] vis) {
        int steps = 0;
        int i = 0;
        while (i < 3) {
            if (!vis[i] && initial[i]!=fin[i]) {
                int r = fin[i] % initial[i];
                int q = fin[i] / initial[i];
                if (i == 0) {
                    if (r > 0) {
                        int r1 = fin[i + 1] % initial[i + 1];
                        int r2 = fin[i + 2] % initial[i + 2];
                        if ((fin[i + 1] % (initial[i + 1] + r) <= r1) && (fin[i + 2] % (initial[i + 2] + r) <= r2) && !vis[i + 1] && vis[i + 2] && r1 != 0 && r2 != 0) {
                            initial[i] += r;
                            initial[i + 1] += r;
                            initial[i + 2] += r;
                            steps++;
                        } else if ((fin[i + 1] % (initial[i + 1] + r) <= r1) && (fin[i + 2] % (initial[i + 2] + r) > r2) && !vis[i + 1] && r1 != 0 && r2 != 0 && !vis[i + 2]) {
                            initial[i] += r;
                            initial[i + 1] += r;
                            steps++;
                        } else if ((fin[i + 2] % (initial[i + 2] + r) <= r2) && (fin[i + 1] % (initial[i + 1] + r) >r1) && !vis[i + 2] && r2 != 0 && !vis[i + 1] && r1 != 0) {
                            initial[i] += r;
                            initial[i + 2] += r;
                            steps++;
                        } else {
                            if (q == 0) {
                                if (r < r1 && r < r2) {
                                    initial[i] += r;
                                    initial[i + 1] += r;
                                    initial[i + 2] += r;
                                    steps++;
                                } else if (r < r1 && r > r2) {
                                    initial[i] += r;
                                    initial[i + 1] += r;
                                    steps++;
                                } else if (r > r1 && r < r2) {
                                    initial[i] += r;
                                    initial[i + 2] += r;
                                    steps++;
                                } else {
                                    initial[i] += r;
                                    steps++;
                                }
                            } else if (q == 1) {
                                int q1 = fin[i + 1] / initial[i + 1];
                                int q2 = fin[i + 2] / initial[i + 2];
                                if (q1 == 1 && q2 == 1) {
                                    if (r != 0) {
                                        initial[i] += r;
                                        steps++;
                                    }
                                    if (r1 != 0 && !vis[i + 1]) {
                                        initial[i + 1] += r1;
                                        steps++;
                                    }
                                    if (r2 != 0 && !vis[i + 2]) {
                                        initial[i + 2] += r2;
                                        steps++;
                                    }
                                } else if (q1 != 1 && q2 == 1 && r1 != 0 && !vis[i + 1] && (r1 / q1 == 1)) {
                                    initial[i]++;
                                    initial[i + 2]++;
                                    initial[i + 1]++;
                                    steps++;
                                } else if (q1 == 1 && q2 != 1 && r2 != 0 && !vis[i + 2] && (r2 / q2 == 1)) {
                                    initial[i]++;
                                    initial[i + 1]++;
                                    initial[i + 2]++;
                                    steps++;
                                } else {
                                    initial[i] += r;
                                    steps++;
                                }
                            } else {
                                int q1 = fin[i + 1] / initial[i + 1];
                                int q2 = fin[i + 2] / initial[i + 2];
                                if (q1 == 1 && q2 == 1) {
                                    if (r1 != 0 && !vis[i + 1]) {
                                        initial[i + 1] += r1;
                                        steps++;
                                    }
                                    if (r2 != 0 && !vis[i + 2]) {
                                        initial[i + 2] += r2;
                                        steps++;
                                    }
                                } else if (q1 == 1 && q2 != 1 && r != 0 && r2 != 0 && !vis[i + 2] && (r / q == 1) && (r2 / q2 == 1)) {
                                    initial[i + 1]++;
                                    initial[i]++;
                                    initial[i + 2]++;
                                    steps++;
                                } else if (q1 != 1 && q2 == 1 && r != 0 && r1 != 0 && !vis[i + 1] && (r / q == 1) && (r1 / q1 == 1)) {
                                    initial[i + 2]++;
                                    initial[i]++;
                                    initial[i + 1]++;

                                    steps++;
                                } else {
                                    if ((fin[i + 1] / initial[i + 1] > 1) && (fin[i + 2] / initial[i + 2] > 1) && !vis[i + 1] && !vis[i + 2]) {
                                        int g = gcd(q, gcd(q1, q2));
                                        if (g > 1) {
                                            initial[i] *= g;
                                            initial[i + 1] *= g;
                                            initial[i + 2] *= g;
                                            steps++;
                                        }
                                    } else if ((fin[i + 1] / initial[i + 1] == 1) && (fin[i + 2] / initial[i + 2] > 1) && !vis[i + 2] && !vis[i + 1]) {
                                        q2 = fin[i + 2] / initial[i + 2];
                                        int g = gcd(q, q2);
                                        if (g > 1) {
                                            initial[i] *= g;
                                            initial[i + 2] *= g;
                                            steps++;
                                        }
                                    } else if ((fin[i + 1] / initial[i + 1] > 1) && (fin[i + 2] / initial[i + 2] == 1) && !vis[i + 1] && !vis[i + 2]) {
                                        q1 = fin[i + 1] / initial[i + 1];
                                        int g = gcd(q, q1);
                                        if (g > 1) {
                                            initial[i] *= g;
                                            initial[i + 1] *= g;
                                            steps++;
                                        }
                                    } else {
                                        initial[i] *= q;
                                        steps++;
                                    }
                                }
                            }
                        }
                    } else {
                        int r1 = fin[i + 1] % initial[i + 1];
                        int r2 = fin[i + 2] % initial[i + 2];
                        if ((fin[i] % (initial[i] + r1) <= r) && (fin[i + 2] % (initial[i + 2] + r1) <= r2) && !vis[i + 1] && !vis[i] && r1 != 0 && !vis[i + 2] && r2 != 0) {
                            initial[i] += r1;
                            initial[i + 1] += r1;
                            initial[i + 2] += r1;
                            steps++;
                        } else if ((fin[i] % (initial[i] + r2) <= r) && (fin[i + 1] % (initial[i + 1] + r2) <= r1) && !vis[i + 1] && !vis[i + 2] && r2 != 0 && r1 != 0) {
                            initial[i] += r2;
                            initial[i + 2] += r2;
                            initial[i + 1] += r2;
                            steps++;
                        } else if (!vis[i + 1] && (fin[i] % (initial[i] + r1) <= r)  && r1 != 0) {
                            initial[i] += r1;
                            initial[i + 1] += r1;
                            steps++;
                        } else if ((fin[i] % (initial[i] + r2) <= r) && !vis[i + 2] && r2 != 0) {
                            initial[i] += r2;
                            initial[i + 2] += r2;
                            steps++;
                        } else {
                            if ((fin[i + 1] / initial[i + 1] > 1) && (fin[i + 2] / initial[i + 2] > 1) && !vis[i + 1] && !vis[i + 2]) {
                                int q1 = fin[i + 1] / initial[i + 1];
                                int q2 = fin[i + 2] / initial[i + 2];
                                int g = gcd(q, gcd(q1, q2));
                                if (g > 1) {
                                    initial[i] *= g;
                                    initial[i + 1] *= g;
                                    initial[i + 2] *= g;
                                    steps++;
                                }
                            } else if ((fin[i + 1] / initial[i + 1] == 1) && (fin[i + 2] / initial[i + 2] > 1) && !vis[i + 2]) {
                                int q2 = fin[i + 2] / initial[i + 2];
                                int g = gcd(q, q2);
                                if (g > 1) {
                                    initial[i] *= g;
                                    initial[i + 2] *= g;
                                    steps++;
                                }
                            } else if ((fin[i + 1] / initial[i + 1] > 1) && (fin[i + 2] / initial[i + 2] == 1) && !vis[i + 1]) {
                                int q1 = fin[i + 1] / initial[i + 1];
                                int g = gcd(q, q1);
                                if (g > 1) {
                                    initial[i] *= g;
                                    initial[i + 1] *= g;
                                    steps++;
                                }
                            } else {
                                initial[i] *= q;
                                steps++;
                            }
                        }
                    }
                } else if (i == 1) {
                    if (r > 0) {
                        int r1 = fin[i + 1] % initial[i + 1];
                        if ((fin[i + 1] % (initial[i + 1] + r) <= r1) && !vis[i + 1] && r1 != 0) {
                            initial[i] += r;
                            initial[i + 1] += r;
                            steps++;
                        } else {
                            if (q == 0) {
                                if (r < r1 && !vis[i + 1]) {
                                    initial[i] += r;
                                    initial[i + 1] += r;
                                    steps++;
                                } else {
                                    initial[i] += r;
                                    steps++;
                                }
                            } else if (q == 1) {
                                int q1 = fin[i + 1] / initial[i + 1];
                                if (q1 == 1) {
                                    if (r != 0) {
                                        initial[i] += r;
                                        steps++;
                                    }
                                    if (r1 != 0 && !vis[i + 1]) {
                                        initial[i + 1] += r1;
                                        steps++;
                                    }
                                } else {
                                    if (r1 != 0 && !vis[i + 1] && (r1 / q1 == 1)) {
                                        initial[i]++;
                                        initial[i + 1]++;
                                        steps++;
                                    }
                                    if (r < r1 && !vis[i + 1]) {
                                        initial[i] += r;
                                        initial[i + 1] += r;
                                        steps++;
                                    } else {
                                        initial[i] += r;
                                        steps++;
                                    }
                                }
                            } else {
                                int q1 = fin[i + 1] / initial[i + 1];
                                if (!vis[i + 1]) {
                                    if (q1 > 1) {
                                        int g = gcd(q, q1);
                                        if (g > 1) {
                                            initial[i] *= g;
                                            initial[i + 1] *= g;
                                            steps++;
                                        } else {
                                            initial[i] *= q;
                                            steps++;
                                        }
                                    } else {
                                        initial[i] *= q;
                                        steps++;
                                    }
                                }
                            }
                        }
                    } else {
                        int r1 = fin[i + 1] % initial[i + 1];
                        if ((fin[i] % (initial[i] + r1) <= r) && !vis[i + 1] && r1 != 0) {
                            initial[i] += r1;
                            initial[i + 1] += r1;
                            steps++;
                        } else {
                            if (q > 1 && !vis[i + 1]) {
                                int q1 = fin[i + 1] / initial[i + 1];
                                if (q1 > 1) {
                                    int g = gcd(q, q1);
                                    if (g > 1) {
                                        initial[i] *= g;
                                        initial[i + 1] *= g;
                                        steps++;
                                    }
                                } else {
                                    initial[i] *= q;
                                    steps++;
                                }
                            }
                        }
                    }
                } else {
                    if (q > 1 && !vis[i]) {
                        initial[i] *= q;
                        steps++;
                    }
                    if (r != 0 && !vis[i]) {
                        initial[i] += r;
                        steps++;
                    }
                }
                if((fin[i]%initial[i] == r) && (fin[i]/initial[i] == q) ){
                    q = fin[i]/initial[i];
                    r = fin[i]%initial[i];
                    if(q > 0){
                        initial[i]*=q;
                        steps++;
                    }
                    if(r!=0){
                        initial[i]+=r;
                        steps++;
                    }
                }
                if (initial[i] == fin[i]) {
                    vis[i] = true;
                }
                if (vis[i]) {
                    i++;
                }
            } else {
                if(initial[i] == fin[i] || vis[i]){
                    i++;
                }
            }
        }
        return steps;
    }
}

