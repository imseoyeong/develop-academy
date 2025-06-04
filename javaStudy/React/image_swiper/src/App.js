import './App.css';
import {Swiper, SwiperSlide} from "swiper/react";
import {Autoplay, Navigation, Pagination} from "swiper/modules";
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';

const swiperOptions = {
    modules: [Autoplay, Pagination, Navigation],
    spaceBetween: 30,
    slidesPerView: 1,
    loop: true,
    autoplay: {
        delay: 3000,
        disableOnInteraction: false,
    },
    pagination: {
        clickable: true,
    },
    navigation: true,
};

function App() {
    return (
        <>
            <Swiper className={"swiper-wrap"} {...swiperOptions}>
                <SwiperSlide className={"swiper-slide"}><img src={"/media/england1.jpg"}/></SwiperSlide>
                <SwiperSlide className={"swiper-slide"}><img src={"/media/england2.jpg"}/></SwiperSlide>
                <SwiperSlide className={"swiper-slide"}><img src={"/media/england4.jpg"}/></SwiperSlide>
            </Swiper>
        </>
    );
}

export default App;
