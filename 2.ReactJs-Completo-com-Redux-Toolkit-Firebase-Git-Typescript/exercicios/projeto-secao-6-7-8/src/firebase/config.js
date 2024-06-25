import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";

const firebaseConfig = {
  apiKey: "AIzaSyB0QCfNHPPO0mNvlEG0ct2AgAV-HwUn420",
  authDomain: "lista-de-leitura-izaias.firebaseapp.com",
  projectId: "lista-de-leitura-izaias",
  storageBucket: "lista-de-leitura-izaias.appspot.com",
  messagingSenderId: "828795397625",
  appId: "1:828795397625:web:b3126a35ae8400b562c928"
};

const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
export const db = getFirestore(app);