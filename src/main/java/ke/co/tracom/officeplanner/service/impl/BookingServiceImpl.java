package ke.co.tracom.officeplanner.service.impl;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import ke.co.tracom.officeplanner.entity.token.ConfirmationToken;
import ke.co.tracom.officeplanner.repository.BookingRepository;
import ke.co.tracom.officeplanner.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void bookingSave(Booking booking) {
//        Booking planner = bookingRepository.findById(u)
        bookingRepository.save(booking);

//        Booking booking = userRepository.findByEmail(user.getEmail());
//        if (existingUser != null) {
//            model.addAttribute("message", "this email already exists");
//            return "error";
//        }
//        else{
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//            String encoder = passwordEncoder.encode(user.getPassword());
//            user.setPassword(encoder);
//
//            userRepository.save(user);
//
//            ConfirmationToken confirmationToken = new ConfirmationToken(user);
//
//            confirmationTokenRepository.save(confirmationToken);
//
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setSubject("Complete Registration");
//            mailMessage.setFrom("wairimuianmoon@gmail.com");
//            mailMessage.setText("To confirm your account, please click here:"+
//                    "http://localhost:8080/confirm-account?token="+
//                    confirmationToken.getConfirmationToken());
//
//            emailSenderService.sendEmail(mailMessage);
//
//            model.addAttribute("emailId", user.getEmail());
//
//            return "registration-success";
    }

}
