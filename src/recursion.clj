(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll) (product (rest coll)))))

(defn singleton? [coll]
  (and (not (empty? coll)) (empty? (rest coll))))

(defn my-last [coll]
  (if (empty? (rest coll))
    (first coll)
    (my-last (rest coll))))

(defn max-element [a-seq]
  (cond
   (empty? a-seq) nil
   (empty? (rest a-seq)) (first a-seq)
   :else (max (first a-seq) (max-element (rest a-seq)))))

(defn seq-max [seq-1 seq-2]
  (if (<= (count seq-1) (count seq-2))
    seq-2
    seq-1))

(defn longest-sequence [a-seq]
  (cond
   (empty? a-seq) nil
   (empty? (rest a-seq)) (first a-seq)
   :else (seq-max (first a-seq) (longest-sequence (rest a-seq)))))

(defn my-filter [pred? a-seq]
  (cond
   (empty? a-seq) a-seq
   (pred? (first a-seq)) (cons (first a-seq) (my-filter pred? (rest a-seq)))
   :else (my-filter pred? (rest a-seq))))

(defn sequence-contains? [elem a-seq]
  (cond
   (empty? a-seq) false
   (== elem (first a-seq)) true
   :else (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (cond
   (empty? a-seq) a-seq
   (pred? (first a-seq)) (cons (first a-seq) (my-take-while pred? (rest a-seq)))
   :else ()))

(defn my-drop-while [pred? a-seq]
  (cond
   (empty? a-seq) a-seq
   (pred? (first a-seq)) (my-drop-while pred? (rest a-seq))
   :else a-seq))

(defn seq= [a-seq b-seq]
  (cond
   (and (empty? a-seq) (empty? b-seq)) true
   (or (empty? a-seq) (empty? b-seq)) false
   (not (== (first a-seq) (first b-seq))) false
   :else (seq= (rest a-seq) (rest b-seq))))

(defn my-map [f seq-1 seq-2]
  (if (or (empty? seq-1) (empty? seq-2))
    ()
    (cons (f (first seq-1) (first seq-2)) (my-map f (rest seq-1) (rest seq-2)))))

(defn power [n k]
  (if (== k 0)
    1
    (* n (power n (dec k)))))

(defn fib [n]
  (cond
   (== n 0) 0
   (== n 1) 1
   :else (+ (fib (dec n)) (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (< how-many-times 1)
    ()
    (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (if (zero? up-to)
    ()
    (cons (dec up-to) (my-range (dec up-to)))))

(defn tails [a-seq]
  (if (empty? a-seq)
    [a-seq]
    (cons a-seq (tails (rest a-seq)))))

(defn inits [a-seq]
  (map reverse (tails (reverse a-seq))))

(defn rotations [a-seq]
  (if (empty? a-seq)
    [a-seq]
    (rest (map concat (tails a-seq) (reverse (inits a-seq))))))

(defn my-frequencies-helper [freqs a-seq]
  (cond
   (empty? a-seq) freqs
   (contains? freqs (first a-seq)) (my-frequencies-helper (assoc freqs (first a-seq) (inc (get freqs (first a-seq)))) (rest a-seq))
   :else (my-frequencies-helper (assoc freqs (first a-seq) 1) (rest a-seq))))

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))

(defn un-frequencies [a-map]
  (if (empty? a-map)
    a-map
    (concat (repeat (val (first a-map)) (key (first a-map))) (un-frequencies (rest a-map)))))

(defn my-take [n coll]
  (if (or (empty? coll) (== n 0))
    []
    (cons (first coll) (my-take (dec n) (rest coll)))))

(defn my-drop [n coll]
  (if (== n 0)
    coll
    (my-drop (dec n) (rest coll))))

(defn halve [a-seq]
  (vector
   (my-take (int (/ (count a-seq) 2)) a-seq)
   (my-drop (int (/ (count a-seq) 2)) a-seq)))

(defn seq-merge [a-seq b-seq]
  (cond
   (and (empty? a-seq) (empty? b-seq)) a-seq
   (empty? a-seq) b-seq
   (empty? b-seq) a-seq
   :else (if (< (first a-seq) (first b-seq))
           (cons (first a-seq) (seq-merge (rest a-seq) b-seq))
           (cons (first b-seq) (seq-merge a-seq (rest b-seq))))))

(defn merge-sort [a-seq]
  (if (or (== (count a-seq) 0) (== (count a-seq) 1))
    a-seq
    (let [[fst snd] (halve a-seq)]
      (seq-merge (merge-sort fst) (merge-sort snd)))))

(defn split-into-monotonics [a-seq]
  (if (empty a-seq)
    []
    []))

(defn permutations [a-set]
  (if (empty? a-set)
    '(())
    '(())))

(defn powerset [a-set]
  (if (empty? a-set)
    #{#{}}
    #{#{}}))
