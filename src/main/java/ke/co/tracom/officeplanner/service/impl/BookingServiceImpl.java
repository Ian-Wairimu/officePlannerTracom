package ke.co.tracom.officeplanner.service.impl;

import ke.co.tracom.officeplanner.entity.booking.Booking;
import ke.co.tracom.officeplanner.entity.user.User;
import ke.co.tracom.officeplanner.repository.BookingRepository;
import ke.co.tracom.officeplanner.repository.ConfirmationTokenRepository;
import ke.co.tracom.officeplanner.repository.UserRepository;
import ke.co.tracom.officeplanner.service.BookingService;
import ke.co.tracom.officeplanner.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailSenderService emailSenderService;
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingServiceImpl(UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, EmailSenderService emailSenderService, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailSenderService = emailSenderService;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void bookingSave(Booking booking) {
        User bookingUser = new User();

        bookingRepository.save(booking);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(bookingUser.getEmail());
        mailMessage.setSubject("Complete Registration");
        mailMessage.setFrom("wairimuianmoon@gmail.com");
        mailMessage.setText("To confirm your account, please click here:");

        emailSenderService.sendEmail(mailMessage);

    }

}
