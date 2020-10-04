package services

import play.api.libs.mailer._

object MailerService {

  def sendEmail: Email = {
    val cid = "1234"
    val email = Email(
      "Simple email",
      "your-mail-id", //update
      Seq("senders-mail-id"), //update
      bodyText = Some("A text message"),
      bodyHtml = Some(s"""<html><body><p>An <b>html</b> message with cid <img src="cid:$cid"></p></body></html>""")
    )
    email
  }

}