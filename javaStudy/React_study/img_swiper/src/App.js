import logo from './logo.svg';
import './App.css';
import {Autoplay, Navigation, Pagination} from "swiper/modules";
import {Swiper, SwiperSlide} from "swiper/react";

import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';

function App() {
    const imgList = [
        {id: 1, src: "/img/animal1", title: "강아지"},
        {id: 2, src: "/img/animal2", title: "고양이"},
        {id: 3, src: "/img/animal3", title: "너구리"},
        {id: 4, src: "/img/animal4", title: "북극여우"},
        {id: 5, src: "/img/animal5", title: "판다"},
        {id: 6, src: "/img/animal6", title: "북극곰"},
        {id: 7, src: "/img/animal7", title: "가젤"},
    ];

    return (
        <section>
            <Swiper
                modules = {[Autoplay, Pagination, Navigation]}
                spaceBetween = {30}
                slidesPerView = {1}
                loop = {true}
                autoplay = {{delay: 3000, disableOnInteraction: false}}
                pagination = {{clickable: true}}
                navigation = {true}
            >
                {imgList.map((item) =>
                <SwiperSlide key={item.id}>
                    <h2>{item.title}</h2>
                    <img src={`${item.src}.jpg`} alt={item.title}/>
                </SwiperSlide>
                )}
            </Swiper>
        </section>
    );
}

export default App;
